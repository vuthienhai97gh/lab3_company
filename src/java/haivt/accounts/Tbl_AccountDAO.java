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
            if(con != null){
                String sql = "Select m.user_id, m.password, m.name, r.role_name "
                        + "from dbo.members as m join role as r on m.role = r.id "
                        + "where m.user_id = ? and m.password= ? and status = 1";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    user = new Tbl_AccountDTO();
                    user.setUsername(rs.getString("user_id"));
                    user.setPassword(rs.getString("password"));
                    user.setFullName(rs.getString("name"));
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

}
