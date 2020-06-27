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

                String sql = "select rs.id, rs.resource_name, cl.color_name, ct.category_name, rs.quantity, rs.from_date, rs.to_date "
                        + "from dbo.resource as rs join dbo.category as ct on rs.category_id = ct.id join dbo.color as cl  on rs.color_id = cl.id "
                        + "where rs.resource_name like ? and rs.from_date >= ? and rs.to_date <= ? and rs.category_id = ?";
                if (category.equalsIgnoreCase("0")) {
                    sql = "select rs.id, rs.resource_name, cl.color_name, ct.category_name, rs.quantity, rs.from_date, rs.to_date "
                            + "from dbo.resource as rs join dbo.category as ct on rs.category_id = ct.id join dbo.color as cl  on rs.color_id = cl.id "
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
                        dto.setResourceId(rs.getInt("id"));
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
                        dto.setResourceId(rs.getInt("id"));
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
}
