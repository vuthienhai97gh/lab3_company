/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.cart;

import haivt.resources.Tbl_ResourceDTO;
import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class Tbl_CartObj implements Serializable{
    private Tbl_ResourceDTO resourceDTO;
    private int quantity;

    public Tbl_CartObj() {
    }

    public Tbl_CartObj(Tbl_ResourceDTO resourceDTO, int quantity) {
        this.resourceDTO = resourceDTO;
        this.quantity = quantity;
    }

    public Tbl_ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(Tbl_ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
