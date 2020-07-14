/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.cart.Tbl_CartObj;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DELL
 */
public class RemoveFromCartAction {

    private int resourceId;

    public RemoveFromCartAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        List<Tbl_CartObj> shoppingCart = (List<Tbl_CartObj>) session.get("shoppingCart");
        if (!shoppingCart.isEmpty()) {
            int location;
            boolean result = false;
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getResourceDTO().getResourceId() == resourceId) {
                    location = i;
                    shoppingCart.remove(location);
                    result = true;
                }
            }
            if(result){
                request.setAttribute("CART_STATUS", "Remove item success.");
            }else{
                request.setAttribute("CART_STATUS", "Remove item fail.");
            }
            
        } 
        return "success";
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    

}
