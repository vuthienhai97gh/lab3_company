/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.resources;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author vuthi
 */
public class Tbl_ResourceDTO implements Serializable{
    private int resourceId;
    private String resourceName;
    private int quantity;
    private String categoryName;
    private String colorName;
    private Date date;

    public Tbl_ResourceDTO(int resourceId, String resourceName, int quantity, String categoryName, String colorName, Date date) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.colorName = colorName;
        this.date = date;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public Tbl_ResourceDTO() {
    }
}
