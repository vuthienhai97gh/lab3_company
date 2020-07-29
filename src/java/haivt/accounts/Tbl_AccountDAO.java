/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.accounts;

import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class Tbl_AccountDAO implements Serializable {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Tbl_AccountDTO checkLogin(String username, String password) throws SQLException, NamingException {
        Tbl_AccountDTO user = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select m.member_id, m.user_id, m.password, m.fullname, r.role_name "
                        + "from dbo.members as m join role as r on m.role = r.role_id "
                        + "where m.user_id = ? and m.password= ? and status = 1";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);

                rs = ps.executeQuery();
                if (rs.next()) {
                    user = new Tbl_AccountDTO();
                    user.setUsername(rs.getString("user_id"));
                    user.setMemberId(rs.getInt("member_id"));
                    user.setPassword(rs.getString("password"));
                    user.setFullName(rs.getString("fullname"));
                    user.setRole(rs.getString("role_name"));
                }
            }
        } finally {//tạo sau đóng trc
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

        return user;
    }
 public Tbl_AccountDTO getInformationUser(String username) throws SQLException, NamingException {
        Tbl_AccountDTO user = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select m.member_id, m.user_id, m.password, m.fullname, r.role_name "
                        + "from dbo.members as m join role as r on m.role = r.role_id "
                        + "where m.user_id = ? and status = 1";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);

                rs = ps.executeQuery();
                if (rs.next()) {
                    user = new Tbl_AccountDTO();
                    user.setUsername(rs.getString("user_id"));
                    user.setMemberId(rs.getInt("member_id"));
                    user.setPassword(rs.getString("password"));
                    user.setFullName(rs.getString("fullname"));
                    user.setRole(rs.getString("role_name"));
                }
            }
        } finally {//tạo sau đóng trc
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

        return user;
    }
 public Tbl_AccountDTO getInformationUserById(int memberId) throws SQLException, NamingException {
        Tbl_AccountDTO user = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select member_id, user_id, password, fullname "
                        + "from dbo.members  "
                        + "where member_id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, memberId);

                rs = ps.executeQuery();
                if (rs.next()) {
                    user = new Tbl_AccountDTO();
                    user.setUsername(rs.getString("user_id"));
                    user.setMemberId(rs.getInt("member_id"));
                    user.setPassword(rs.getString("password"));
                    user.setFullName(rs.getString("fullname"));
                
                }
            }
        } finally {//tạo sau đóng trc
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

        return user;
    }
    public boolean createNewAccount(String userId, String password, String name, String phone, String address) throws SQLException, NamingException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into dbo.members (user_id ,password ,fullname ,phone ,address) values (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql);

                ps.setString(1, userId);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setString(4, phone);
                ps.setString(5, address);
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

    public boolean updateStatusAccount(String userId, int status) throws SQLException, NamingException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update dbo.members set status = ? where user_id = ?";
                ps = con.prepareStatement(sql);

                ps.setInt(1, status);
                ps.setString(2, userId);

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

    public boolean checkDuplicateEmail(String userId)
            throws SQLException, NamingException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select user_id from dbo.members where user_id = ?";
                ps = con.prepareStatement(sql);

                ps.setString(1, userId);

                 rs = ps.executeQuery();
                if (rs.next()) {
                    return false;
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
        return true;
    }
}
