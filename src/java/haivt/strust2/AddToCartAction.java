/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.cart.Tbl_CartObj;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class AddToCartAction {

    private String memberId;
    private String resourceId;

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        List<Tbl_CartObj> shoppingCart;
        Tbl_ResourceDTO resourceDTO;
        Tbl_ResourceDAO resourceDAO = new Tbl_ResourceDAO();

        resourceDTO = resourceDAO.getResourceById(resourceId);
        shoppingCart = (List<Tbl_CartObj>) session.get("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<>();
            shoppingCart.add(new Tbl_CartObj(resourceDTO, 1));
            request.setAttribute("CART_STATUS", "Add success.");
        } else {
            boolean isExistted = false;
            int location = -1;
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getResourceDTO().getResourceId() == Integer.valueOf(resourceId)) {
                    isExistted = true;
                    location = i;
                }
            }
            if (isExistted) {
                shoppingCart.get(location).setQuantity(shoppingCart.get(location).getQuantity() + 1);
                request.setAttribute("CART_STATUS", "Add one more success");
            } else {
                shoppingCart.add(new Tbl_CartObj(resourceDTO, 1));
                request.setAttribute("CART_STATUS", "Add success");
            }
        }
        session.put("shoppingCart", shoppingCart);
        return "success";
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

}
