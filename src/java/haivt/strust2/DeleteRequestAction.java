/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.accounts.Tbl_AccountDAO;
import haivt.accounts.Tbl_AccountDTO;
import haivt.list.request.Tbl_ListRequestDAO;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import haivt.utils.SendMailUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class DeleteRequestAction {

    private String requestId;
    private String requestName;
    private int memberId;
    private List<Tbl_ResourceDTO> detailList;
    private final String SUCCESS = "success";

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<Tbl_ResourceDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Tbl_ResourceDTO> detailList) {
        this.detailList = detailList;
    }

    public DeleteRequestAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Tbl_ListRequestDAO requestDao = new Tbl_ListRequestDAO();
        Tbl_ResourceDAO bookingDetailDAO = new Tbl_ResourceDAO();

        boolean isSuccess = requestDao.updateStatusRequest(requestId, 4);
        if (isSuccess) {
            bookingDetailDAO.getListResourceByRequestId(Integer.parseInt(requestId));
            Tbl_AccountDAO dao = new Tbl_AccountDAO();
            Tbl_AccountDTO account = dao.getInformationUserById(memberId);
            detailList = bookingDetailDAO.getList();
            if (account != null) {
                for (Tbl_ResourceDTO item : detailList) {
                    bookingDetailDAO.updateQuantityIncreare(item.getResourceId(), item.getQuantity());
                }
                SendMailUtils.sendSimpleEmail(account.getUsername(), "Hello " + account.getFullName() + " Your booking request name " + requestName + " has been cancel by MANAGER please check your request booking history", "ACCEPT BOOKING FAIL !!!");
            }
            request.setAttribute("DELETE_STATUS", "Delete success.");
        } else {
            request.setAttribute("DELETE_STATUS", "Delete Fail");
        }

        return SUCCESS;
    }

}
