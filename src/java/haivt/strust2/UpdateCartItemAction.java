/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import haivt.cart.Tbl_CartObj;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DELL
 */
public class UpdateCartItemAction extends ActionSupport {

    private int resourceId;
    private String quantity;

    public UpdateCartItemAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        List<Tbl_CartObj> shoppingCart = (List<Tbl_CartObj>) session.get("shoppingCart");
        if (!shoppingCart.isEmpty()) {
            int location = 0;
            boolean result = false;
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getResourceDTO().getResourceId() == resourceId) {
                    location = i;
                    result = true;
                }
            }
            if(result){
            shoppingCart.get(location).setQuantity(Integer.valueOf(quantity));
            
            session.put("shoppingCart", shoppingCart);
            request.setAttribute("CART_STATUS", "Update quantity success.");
            }else{
                request.setAttribute("CART_STATUS", "Update quantity fail.");
            }
        }
        return "success";
    }

    @Override
    public void validate() {
        if (this.quantity.length() == 0 || this.quantity.isEmpty()) {
            addFieldError("quantity", "Quantity required!");
        }
        if (!this.quantity.matches("^[0-9]*[1-9][0-9]*$")) {
            addFieldError("quantity", "Quantity must be positive integer number!");
        }
    }

    

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    
    

}
