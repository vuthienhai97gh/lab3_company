/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionSupport;
import haivt.accounts.Tbl_AccountDAO;
import haivt.utils.PasswordUtilities;
import haivt.utils.SendMailUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author phong
 */
public class CreateAccountAction extends ActionSupport {

    private String userId;
    private String password;
    private String confirmPassword;
    private String name;
    private String phone;
    private String address;

    private final String SUCCESS = "success";

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public CreateAccountAction() {
    }

    public String execute() throws Exception {
        Tbl_AccountDAO dao = new Tbl_AccountDAO();
        PasswordUtilities pass = new PasswordUtilities();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (userId.length() != 0 && !dao.checkDuplicateEmail(userId)) {
            addFieldError("userId", "Duplicate Email !!");

        } else {
            boolean result = dao.createNewAccount(userId, pass.getEncryptPassword(password), name, phone, address);
            if (result) {
                SendMailUtils.sendSimpleEmail(userId, "http://localhost:8080/Lab3_Company/verify.action?email=" + userId, "verify the email");
                request.setAttribute("CREATE_STATUS", "Create account success please check your mail!!!");
            } else {
                request.setAttribute("CREATE_STATUS", "Create account failed!");
            }
        }

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (this.userId.length() == 0) {
            addFieldError("userId", "Required!");
        } else if (!this.userId.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            addFieldError("userId", "Wrong email format!");
        }
        if (this.name.length() == 0) {
            addFieldError("name", "Required!");
        }
        if (this.password.length() == 0) {
            addFieldError("password", "Required!");
        } else if (!this.password.matches("^[a-zA-Z0-9äöüÄÖÜ]{5,15}$")) {
            addFieldError("password", "Password ko chua ky tu dac biet, ko chua khoang trang, toi da 5 den 15 ky tu!");
        }
        if (!this.confirmPassword.equals(this.password)) {
            addFieldError("confirmPassword", "Must match with password!");
        }
        if (this.phone.length() == 0) {
            addFieldError("phone", "Required!");
        } else if (!this.phone.matches("^[0-9]{10,11}$")) {
            addFieldError("phone", "Phone must contain 8 to 12 number digits");
        }
        if (this.address.length() == 0) {
            addFieldError("address", "Required!");
        }

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
