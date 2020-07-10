/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.cart;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_CartDTO implements Serializable{
    private int resourceId;
    private String resourceName;

    public Tbl_CartDTO() {
    }

    public Tbl_CartDTO(int resourceId, String resourceName) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
