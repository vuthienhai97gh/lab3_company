/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.accounts.Tbl_AccountDAO;
import haivt.accounts.Tbl_AccountDTO;
import haivt.utils.PasswordUtilities;
import java.util.Map;

/**
 *
 * @author vuthi
 */
public class LoginAction {
    private String username;
    private String password;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        Tbl_AccountDAO dao = new Tbl_AccountDAO();
        PasswordUtilities pass = new PasswordUtilities();
        Tbl_AccountDTO user = dao.checkLogin(username, pass.getEncryptPassword(password));
        if(user != null){
            Map session = ActionContext.getContext().getSession();
            session.put("USER", user);
            
           
            return SUCCESS;
        }else{
            return FAIL;
        }
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
