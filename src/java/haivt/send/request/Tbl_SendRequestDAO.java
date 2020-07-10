/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.send.request;

import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class Tbl_SendRequestDAO implements Serializable{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public Tbl_SendRequestDAO() {
    }
    private void closeConnection() throws SQLException {
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
    private void openConnection(String sqlQuery) throws SQLException, NamingException {
        con = DBUtils.makeConnection();
        ps = con.prepareStatement(sqlQuery);
    }
    
    public boolean insertRequest(Tbl_SendRequestDTO sendRequestDTO) throws NamingException, SQLException {
        boolean result = false;
        try {
            openConnection("Insert Into request values(?,3,getDate(),?)");
            ps.setInt(1, sendRequestDTO.getMembersId());
            ps.setString(2, sendRequestDTO.getNameRequest());
            result = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    public int getNewestRequest() throws SQLException, NamingException {
        int result = 0;
        try {
            openConnection("Select IDENT_CURRENT('request') as Lastest");
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("Lastest");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
