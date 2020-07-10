/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.accounts;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_AccountDTO implements Serializable{
    private int memberId;
    private String username;
    private String fullName;
    private String password;
    private String role;
    private String status;

    public Tbl_AccountDTO(int memberId, String username, String fullName, String password, String role, String status) {
        this.memberId = memberId;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Tbl_AccountDTO() {
    }
}
