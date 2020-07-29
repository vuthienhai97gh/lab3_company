/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.list.request.Tbl_ListRequestDAO;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class DeactiveRequestAction {

    private String requestId;
    private final String SUCCESS = "success";
    private List<Tbl_ResourceDTO> detailList;

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

    public DeactiveRequestAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

 Tbl_ResourceDAO bookingDetailDAO = new Tbl_ResourceDAO();
        Tbl_ListRequestDAO requestDao = new Tbl_ListRequestDAO();
        boolean isSuccess = requestDao.updateStatusRequest(requestId, 2);
        if (isSuccess) {
            bookingDetailDAO.getListResourceByRequestId(Integer.parseInt(requestId));
            detailList = bookingDetailDAO.getList();
            for (Tbl_ResourceDTO item : detailList) {
                bookingDetailDAO.updateQuantityIncreare(item.getResourceId(), item.getQuantity());
            }
            request.setAttribute("DELETE_STATUS", "Delete success.");
        } else {
            request.setAttribute("DELETE_STATUS", "Delete Fail");
        }

        return SUCCESS;
    }

}
