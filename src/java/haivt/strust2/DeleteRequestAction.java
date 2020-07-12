/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.list.request.Tbl_ListRequestDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class DeleteRequestAction {

    private String requestId;
    private final String SUCCESS = "success";

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public DeleteRequestAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Tbl_ListRequestDAO requestDao = new Tbl_ListRequestDAO();
        boolean isSuccess = requestDao.updateStatusRequest(requestId, 4);
        if(isSuccess){
            request.setAttribute("DELETE_STATUS", "Delete success.");
        }else{
            request.setAttribute("DELETE_STATUS", "Delete Fail");
        }
        
        return SUCCESS;
    }

}
