/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.accounts.Tbl_AccountDTO;
import haivt.cart.Tbl_CartObj;
import haivt.request.resource.Tbl_RequestResourceDAO;
import haivt.request.resource.Tbl_RequestResourceDTO;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import haivt.send.request.Tbl_SendRequestDAO;
import haivt.send.request.Tbl_SendRequestDTO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class SubmitRequestAction {

    public String requestName;

    public SubmitRequestAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String confirmStatus = "fail";
        Map session = ActionContext.getContext().getSession();
        Tbl_AccountDTO accountDTO = (Tbl_AccountDTO) session.get("USER");
        List<Tbl_CartObj> shoppingCart = (List<Tbl_CartObj>) session.get("shoppingCart");
        Tbl_SendRequestDAO requestDAO = new Tbl_SendRequestDAO();
        Tbl_ResourceDAO roomDAO = new Tbl_ResourceDAO();
        Tbl_ResourceDTO roomDTO;
        Tbl_RequestResourceDAO bookDetailDAO = new Tbl_RequestResourceDAO();
        Tbl_RequestResourceDTO bookDetailDTO;
        Tbl_SendRequestDTO sendDTO = new Tbl_SendRequestDTO();
        if (accountDTO != null && session.get("shoppingCart") != null) {
            boolean valid = true;
            for (int i = 0; i < shoppingCart.size(); i++) {
                roomDTO = roomDAO.getResourceById(String.valueOf(shoppingCart.get(i).getResourceDTO().getResourceId()));
                if (shoppingCart.get(i).getQuantity() > roomDTO.getQuantity()) {
                    valid = false;
                    request.setAttribute("CART_STATUS", roomDTO.getResourceName()+ " only have " + roomDTO.getQuantity() + " Quantity");
                }
            }
            if (valid) {
                sendDTO.setMembersId(accountDTO.getMemberId());
                sendDTO.setNameRequest(requestName);
                requestDAO.insertRequest(sendDTO);
                int bookId = requestDAO.getNewestRequest();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    bookDetailDTO = new Tbl_RequestResourceDTO(bookId, shoppingCart.get(i).getResourceDTO().getResourceId(), shoppingCart.get(i).getQuantity());
                    bookDetailDAO.insertBookDetail(bookDetailDTO);
                    roomDAO.updateQuantity(shoppingCart.get(i).getResourceDTO().getResourceId(), shoppingCart.get(i).getQuantity());
                }
                request.setAttribute("CART_STATUS", "Send request success.");
//                session.remove("BookDTO");
//                session.remove("TOTAL_PRICE");
//                session.remove("shoppingCart");
//                session.remove("DURATION");
                confirmStatus = "success";
            } else {
                confirmStatus = "fail";
            }
        } else {
            if (session.get("shoppingCart") == null) {
                request.setAttribute("CART_STATUS", "Your cart is empty!");
            }
        }
        return confirmStatus;
    }

}
