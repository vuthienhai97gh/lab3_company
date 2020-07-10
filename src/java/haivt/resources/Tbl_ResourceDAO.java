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

    public void searchResource(String resourceName, String category, String fromDate, String toDate) throws SQLException, NamingException {
        Date _fromDate = null;
        Date _toDate = null;

//        if (role.equals("ADMIN")) {
        if (fromDate == null || fromDate.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.set(2000, 01, 01);
            _fromDate = new Date(cal.getTimeInMillis());

        } else {
            try {
                _fromDate = Date.valueOf(fromDate);
            } catch (Exception e) {
                Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (toDate == null || toDate.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 20);
            _toDate = new Date(cal.getTimeInMillis());
        } else {
            try {
                _toDate = Date.valueOf(toDate);
            } catch (Exception e) {
                Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

//        } else {
//            if (fromDate == null || fromDate.isEmpty()) {
//                _fromDate = new Date(System.currentTimeMillis());
//
//            } else {
//                try {
//                    _fromDate = Date.valueOf(fromDate);
//                } catch (Exception e) {
//                    Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
//                }
//
//            }
//            if (toDate == null || toDate.isEmpty()) {
//                Calendar cal = Calendar.getInstance();
//                cal.add(Calendar.YEAR, 20);
//                _toDate = new Date(cal.getTimeInMillis());
//            } else {
//                try {
//                    _toDate = Date.valueOf(toDate);
//                } catch (Exception e) {
//                    Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
//                }
//
//            }
//        }
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "select rs.resource_id, rs.resource_name, cl.color_name, ct.category_name, rs.quantity, rs.from_date, rs.to_date "
                        + "from dbo.resource as rs join dbo.category as ct on rs.category_id = ct.category_id join dbo.color as cl on rs.color_id = cl.color_id "
                        + "where rs.resource_name like ? and rs.from_date >= ? and rs.to_date <= ? and rs.category_id = ?";
                if (category.equalsIgnoreCase("0")) {
                    sql = "select rs.resource_id, rs.resource_name, cl.color_name, ct.category_name, rs.quantity, rs.from_date, rs.to_date "
                            + "from dbo.resource as rs join dbo.category as ct on rs.category_id = ct.category_id join dbo.color as cl  on rs.color_id = cl.color_id "
                            + "where rs.resource_name like ? and rs.from_date >= ? and rs.to_date <= ? ";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + resourceName + "%");
                    ps.setDate(2, _fromDate);
                    ps.setDate(3, _toDate);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        Tbl_ResourceDTO dto = new Tbl_ResourceDTO();
                        dto.setResourceId(rs.getInt("resource_id"));
                        dto.setResourceName(rs.getString("resource_name"));
                        dto.setColorName(rs.getString("color_name"));
                        dto.setCategoryName(rs.getString("category_name"));
                        dto.setQuantity(rs.getInt("quantity"));
                        dto.setFromDate(rs.getString("from_date"));
                        dto.setToDate(rs.getString("to_date"));
                        list.add(dto);
                    }
                } else {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + resourceName + "%");
                    ps.setDate(2, _fromDate);
                    ps.setDate(3, _toDate);
                    ps.setString(4, category);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        Tbl_ResourceDTO dto = new Tbl_ResourceDTO();
                        dto.setResourceId(rs.getInt("resource_id"));
                        dto.setResourceName(rs.getString("resource_name"));
                        dto.setColorName(rs.getString("color_name"));
                        dto.setCategoryName(rs.getString("category_name"));
                        dto.setQuantity(rs.getInt("quantity"));
                        dto.setFromDate(rs.getString("from_date"));
                        dto.setToDate(rs.getString("to_date"));
                        list.add(dto);
                    }
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

    public Tbl_ResourceDTO getResourceById(String resourceId) throws NamingException, SQLException {
        Tbl_ResourceDTO result = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select rs.resource_id, rs.color_id, rs.category_id, rs.resource_name, rs.quantity, rs.from_date, ca.category_id, ca.category_name, cl.color_id, cl.color_name "
                        + "from resource rs, category ca, color cl "
                        + "where rs.color_id = cl.color_id and rs.category_id = ca.category_id and rs.resource_id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, resourceId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int rsId = rs.getInt("resource_id");
//                    int colorId = rs.getInt("color_id");
//                    int categoryId = rs.getInt("category_id");
                    String resourceName = rs.getString("resource_name");
                    int availResource = rs.getInt("quantity");
                    String categoryName = rs.getString("category_name");
                    String colorName = rs.getString("color_name");
                    result = new Tbl_ResourceDTO(rsId, resourceName, availResource, categoryName, colorName);
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
        return result;
    }
    public boolean updateQuantity(int resourceId, int rsquantity) throws NamingException, SQLException {
        boolean result = false;
        try {
            con = DBUtils.makeConnection();
            String sql = "Update resource set quantity = quantity - ? Where resource_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, resourceId);
            ps.setInt(2, rsquantity);
            result = ps.executeUpdate() > 0;
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
        return result;
    }

}
