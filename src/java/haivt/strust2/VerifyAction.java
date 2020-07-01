/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.accounts.Tbl_AccountDAO;

/**
 *
 * @author vuthi
 */
public class VerifyAction {
    
    private String email;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public VerifyAction() {
       
    }
    
    public String execute() throws Exception {
         Tbl_AccountDAO dao = new Tbl_AccountDAO();
         boolean result = dao.updateStatusAccount(email, 1);
         if(result){
             return SUCCESS;
         }
         return FAIL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
