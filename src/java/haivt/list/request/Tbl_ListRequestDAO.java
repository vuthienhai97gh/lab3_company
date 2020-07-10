/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.list.request;

import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class Tbl_ListRequestDAO implements Serializable {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Tbl_ListRequestDTO> list;

    public List<Tbl_ListRequestDTO> getList() {
        return list;
    }

    public Tbl_ListRequestDAO() {
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

    public void getAllRequest() throws SQLException, NamingException {
        try {
            openConnection("select m.fullname, r.created_date, r.name, st.status_name from dbo.request r join dbo.members as m on r.members_id = m.member_id join dbo.status as st on r.status_id = st.status_id");
            rs = ps.executeQuery();
            while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        Tbl_ListRequestDTO dto = new Tbl_ListRequestDTO();
                        dto.setResourceName(rs.getString("name"));
                        dto.setMemberNameRequest(rs.getString("fullname"));
                        dto.setDateRequest(rs.getString("created_date"));
                        dto.setStatusName(rs.getString("status_name"));
                        list.add(dto);
                    }
        } finally {
            closeConnection();
        }
    }

}
