/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.request.resource;

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
public class Tbl_RequestResourceDAO implements Serializable{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public Tbl_RequestResourceDAO() {
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
    public boolean insertBookDetail(Tbl_RequestResourceDTO requestResouceDTO) throws SQLException, NamingException {
        boolean result = false;
        try {
            openConnection("Insert Into request_resource values(?,?,?)");
            ps.setInt(1, requestResouceDTO.getRequestId());
            ps.setInt(2, requestResouceDTO.getResourceId());
            ps.setInt(3, requestResouceDTO.getQuantity());
            result = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
}
