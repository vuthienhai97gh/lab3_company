/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.request.resource;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_RequestResourceDTO implements Serializable{
    private int requestId;
    private int resourceId;
    private int quantity;

    public Tbl_RequestResourceDTO() {
    }

    public Tbl_RequestResourceDTO(int requestId, int resourceId, int quantity) {
        this.requestId = requestId;
        this.resourceId = resourceId;
        this.quantity = quantity;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
