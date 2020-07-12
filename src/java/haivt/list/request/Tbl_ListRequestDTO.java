/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.list.request;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_ListRequestDTO implements Serializable{
    private int requestId;
    private String requestName;
    private String memberNameRequest;
    private String statusName;
    private int statusId;
    private int memberId;
    private String dateRequest;
    private String dateUsing;

    public Tbl_ListRequestDTO() {
    }

    public Tbl_ListRequestDTO(int requestId, String requestName, String memberNameRequest, String statusName, int statusId, int memberId, String dateRequest, String dateUsing) {
        this.requestId = requestId;
        this.requestName = requestName;
        this.memberNameRequest = memberNameRequest;
        this.statusName = statusName;
        this.statusId = statusId;
        this.memberId = memberId;
        this.dateRequest = dateRequest;
        this.dateUsing = dateUsing;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    
    


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }



    public String getMemberNameRequest() {
        return memberNameRequest;
    }

    public void setMemberNameRequest(String memberNameRequest) {
        this.memberNameRequest = memberNameRequest;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(String dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getDateUsing() {
        return dateUsing;
    }

    public void setDateUsing(String dateUsing) {
        this.dateUsing = dateUsing;
    }
    
}
