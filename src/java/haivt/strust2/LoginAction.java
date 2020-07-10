/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.accounts.Tbl_AccountDAO;
import haivt.accounts.Tbl_AccountDTO;
import haivt.recaptcha.VerifyRecaptcha;
import haivt.category.Tbl_CategoryDAO;
import haivt.utils.PasswordUtilities;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class LoginAction {

    private String username;
    private String password;

    private Map<Integer, String> listCategory;

    public LoginAction() {
    }

    public Map<Integer, String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(Map<Integer, String> listCategory) {
        this.listCategory = listCategory;
    }

    public String execute() throws Exception {
        Tbl_AccountDAO dao = new Tbl_AccountDAO();
        Tbl_CategoryDAO cateDao = new Tbl_CategoryDAO();
        PasswordUtilities pass = new PasswordUtilities();
        Tbl_AccountDTO user = dao.checkLogin(username, pass.getEncryptPassword(password));
        HttpServletRequest request = ServletActionContext.getRequest();
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        String loginResult = "fail";
        Map request1 = (Map) ActionContext.getContext().get("request");
        if (user != null) {
            if (!verify) {
                request1.put("ERRORCAPTCHA", "Click reCaptCha Please!!!");
                return loginResult;
            }
            Map session = ActionContext.getContext().getSession();
            session.put("USER", user);
            session.put("ROLE", user.getRole());
            cateDao.getCategory();
            listCategory = cateDao.getListCategory();
            return "success";
        } else {
            request1.put("ERROR", "Invalid Username or Password!!!");
            return loginResult;
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
