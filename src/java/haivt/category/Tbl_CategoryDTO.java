/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.category;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_CategoryDTO implements Serializable{
    private String categoryName;
    private int categoryId;

    public Tbl_CategoryDTO() {
    }

    public Tbl_CategoryDTO(String categoryName, int categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
