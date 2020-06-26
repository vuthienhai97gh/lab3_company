/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.resources;

import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class Tbl_ResourceDAO implements Serializable {

    private List<Tbl_ResourceDTO> list;

    public List<Tbl_ResourceDTO> getList() {
        return list;
    }

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void searchResource(String resourceName, String category, Date date) throws SQLException, NamingException {

        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "select rs.id, rs.resource_name, cl.color_name, ct.category_name, rs.quantity, rs.date "
                        + "from dbo.resource as rs join dbo.category as ct on rs.category_id = ct.id join dbo.color as cl  on rs.color_id = cl.id "
                        + "where rs.resource_name like ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + resourceName + "%");
                rs = ps.executeQuery();
                while (rs.next()){ 
                    if(list == null){
                        list = new ArrayList<>();
                    }
                    Tbl_ResourceDTO dto = new Tbl_ResourceDTO();
                    dto.setResourceId(rs.getInt("id"));
                    dto.setResourceName(rs.getString("resource_name"));
                    dto.setColorName(rs.getString("color_name"));
                    dto.setCategoryName(rs.getString("category_name"));
                    dto.setQuantity(rs.getInt("quantity"));
                    dto.setDate(rs.getDate("date"));
                    list.add(dto);
                }
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
