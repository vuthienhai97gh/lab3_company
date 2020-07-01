/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.resources;

import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class Tbl_CategoryDAO implements Serializable {

    private Map<Integer, String> listCategory;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Map<Integer, String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(Map<Integer, String> listCategory) {
        this.listCategory = listCategory;
    }

    public void getCategory() throws SQLException, NamingException {
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "select id,category_name from category";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (listCategory == null) {
                        listCategory = new HashMap<>();
                    }
                    int categoryId = rs.getInt("id");
                    String categoryName = rs.getString("category_name");
                    listCategory.put(categoryId, categoryName);
                }
                listCategory.put(0,"All");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
