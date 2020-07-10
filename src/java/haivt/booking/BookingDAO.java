/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.booking;

import haivt.resources.Tbl_ResourceDAO;
import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author phong
 */
public class BookingDAO implements Serializable {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    public static boolean insertBooking(int resourceId, int memberId, int quantity) throws SQLException, NamingException{
         try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into booking (member_id , resource_id, quantity ) values (?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, memberId);
                ps.setInt(2, resourceId);
                ps.setInt(3, quantity);
                
                int result = ps.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }   
    public static boolean changeStatusBooking(int bookingId, int status) throws SQLException, NamingException{
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update booking set status_name = ? where status_id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, bookingId);
                
                int result = ps.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
    
    public static List<BookingDTO> getBookings(String resourceName, String fromDate, String toDate, int status) throws SQLException, NamingException{
        List<BookingDTO> list = null;
        
        java.sql.Date _fromDate = null;
        java.sql.Date _toDate = null;

        if (fromDate == null || fromDate.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.set(2000, 01, 01);
            _fromDate = new java.sql.Date(cal.getTimeInMillis());

        } else {
            try {
                _fromDate = java.sql.Date.valueOf(fromDate);
            } catch (Exception e) {
                Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (toDate == null || toDate.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 20);
            _toDate = new java.sql.Date(cal.getTimeInMillis());
        } else {
            try {
                _toDate = java.sql.Date.valueOf(toDate);
            } catch (Exception e) {
                Logger.getLogger(Tbl_ResourceDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select b.booking_id, b.resource_id, r.resource_name, m.name, b.status, b.quantity, b.date_created, b.last_updated "
                        + "from booking b join resource r on b.resource_id = r.role_id join members m on b.member_id = m.member_id "
                        + "where r.resource_name like ? "
                        + "and b.date_created between ? and ?"
                        + "and b.status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, resourceName);
                ps.setDate(2, _fromDate);
                ps.setDate(3, _toDate);
                ps.setInt(4, status);
                
                rs = ps.executeQuery();
                while(rs.next()){
                BookingDTO bookingDTO = new BookingDTO();
                bookingDTO.setId(rs.getInt("id"));
                bookingDTO.setResourceId(rs.getInt("resource_id"));
                bookingDTO.setResourceName(rs.getString("resource_name"));
                bookingDTO.setMemberName(rs.getString("name"));
                bookingDTO.setStatus(rs.getInt("status"));
                bookingDTO.setQuantity(rs.getInt("quantity"));
                bookingDTO.setDateCreated(rs.getDate("date_created"));
                bookingDTO.setLastUpdated(rs.getDate("last_updated"));
                list.add(bookingDTO);
            }   
            }
        } finally {
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return list;
    }
}
