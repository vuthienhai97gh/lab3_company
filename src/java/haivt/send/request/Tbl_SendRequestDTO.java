/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.send.request;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_SendRequestDTO implements Serializable{
    private int requestId;
    private int membersId;
    private int statusId;
    private String createdDate;
    private String nameRequest;

    public Tbl_SendRequestDTO() {
    }

    public Tbl_SendRequestDTO(int requestId, int membersId, int statusId, String createdDate, String nameRequest) {
        this.requestId = requestId;
        this.membersId = membersId;
        this.statusId = statusId;
        this.createdDate = createdDate;
        this.nameRequest = nameRequest;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getMembersId() {
        return membersId;
    }

    public void setMembersId(int membersId) {
        this.membersId = membersId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getNameRequest() {
        return nameRequest;
    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
    }
    
}
