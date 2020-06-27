/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.accounts.Tbl_AccountDAO;
import haivt.utils.PasswordUtilities;
import haivt.utils.SendMailUtils;
import java.util.Random;

/**
 *
 * @author phong
 */
public class CreateAccountAction {

    private String userId;
    private String password;
    private String name;
    private long phone;
    private String address;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public CreateAccountAction() {
    }

    public String execute() {
        String code = "";
        int randomNumber = 0;
        Random random = null;
        try {
            Tbl_AccountDAO dao = new Tbl_AccountDAO();
            PasswordUtilities pass = new PasswordUtilities();

            boolean result = dao.createNewAccount(userId, pass.getEncryptPassword(password), name, phone, address);

            if (result) {

                random = new Random();
                for (int i = 0; i < 4; i++) {
                    randomNumber = random.nextInt(9);
                    code += randomNumber;
                }
                SendMailUtils.sendSimpleEmail(userId, "OTP code: "+code , "verify the email");

                return SUCCESS;
            }
        } catch (Exception e) {
        }
        return FAIL;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
