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
    private String fromDate;
    private String toDate;

    public Tbl_ResourceDTO() {
    }

    public Tbl_ResourceDTO(int resourceId, String resourceName, int quantity, String categoryName, String colorName, String fromDate, String toDate) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.colorName = colorName;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    
}
