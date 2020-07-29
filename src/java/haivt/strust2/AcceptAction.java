/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.accounts.Tbl_AccountDAO;
import haivt.accounts.Tbl_AccountDTO;
import haivt.list.request.Tbl_ListRequestDAO;
import haivt.utils.SendMailUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class AcceptAction {
     private String requestId;
     private String requestName;
     private int memberId;
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
    public AcceptAction() {
    }
    
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Tbl_ListRequestDAO requestDao = new Tbl_ListRequestDAO();
        boolean isSuccess = requestDao.updateStatusRequest(requestId, 5);
        if(isSuccess){
            Tbl_AccountDAO dao = new Tbl_AccountDAO();
            Tbl_AccountDTO account = dao.getInformationUserById(memberId);
            if(account != null){
                SendMailUtils.sendSimpleEmail(account.getUsername(), "Hello "+account.getFullName()+" Your booking request name "+requestName+" has been approve by MANAGER please check your request booking history", "ACCEPT BOOKING SUCCESSED !!!");
            }
            request.setAttribute("ACCEPT_STATUS", "Accept success.");
        }else{
            request.setAttribute("ACCEPT_STATUS", "Accept Fail");
        }
        
        return SUCCESS;
    }
    
}
