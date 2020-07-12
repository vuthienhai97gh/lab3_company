/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.list.request;

import haivt.resources.Tbl_ResourceDAO;
import haivt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Map<Integer, String> listStatus;

    public Map<Integer, String> getListStatus() {
        return listStatus;
    }

    public void setListStatus(Map<Integer, String> listStatus) {
        this.listStatus = listStatus;
    }

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

    public void getAllRequest(String resourceName, String fromDate, String toDate, String status) throws SQLException, NamingException {
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
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select DISTINCT m.fullname,r.request_id, r.created_date, r.name, st.status_name \n"
                        + "from dbo.request r join dbo.members as m on r.members_id = m.member_id \n"
                        + "join dbo.status as st on r.status_id = st.status_id \n"
                        + "join dbo.request_resource as rr \n"
                        + "on rr.request_id = r.request_id\n"
                        + "join dbo.resource as rs \n"
                        + "on  rs.resource_id = rr.resource_id\n"
                        + "where rs.resource_name like ?\n"
                        + "and r.created_date between ? and ? and  r.status_id = ?";
                if (status.equalsIgnoreCase("0")) {
                    sql = "select DISTINCT m.fullname,r.request_id, r.created_date, r.name, st.status_name \n"
                            + "from dbo.request r join dbo.members as m on r.members_id = m.member_id \n"
                            + "join dbo.status as st on r.status_id = st.status_id \n"
                            + "join dbo.request_resource as rr \n"
                            + "on rr.request_id = r.request_id\n"
                            + "join dbo.resource as rs \n"
                            + "on  rs.resource_id = rr.resource_id\n"
                            + "where rs.resource_name like ?\n"
                            + "and r.created_date between ? and ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + resourceName + "%");
                    ps.setDate(2, _fromDate);
                    ps.setDate(3, _toDate);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        Tbl_ListRequestDTO dto = new Tbl_ListRequestDTO();
                        dto.setRequestId(rs.getInt("request_id"));
                        dto.setRequestName(rs.getString("name"));
                        dto.setMemberNameRequest(rs.getString("fullname"));
                        dto.setDateRequest(rs.getString("created_date"));
                        dto.setStatusName(rs.getString("status_name"));
                        list.add(dto);
                    }
                } else {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + resourceName + "%");
                    ps.setDate(2, _fromDate);
                    ps.setDate(3, _toDate);
                    ps.setString(4, status);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        Tbl_ListRequestDTO dto = new Tbl_ListRequestDTO();
                        dto.setRequestId(rs.getInt("request_id"));
                        dto.setRequestName(rs.getString("name"));
                        dto.setMemberNameRequest(rs.getString("fullname"));
                        dto.setDateRequest(rs.getString("created_date"));
                        dto.setStatusName(rs.getString("status_name"));
                        list.add(dto);
                    }
                }

            }
        } finally {
            closeConnection();
        }
    }

    public void getStatusName() throws SQLException, NamingException {
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                openConnection("select status_id, status_name from status where status_id in (3,4,5)");
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (listStatus == null) {
                        listStatus = new HashMap<>();
                    }
                    int statusId = rs.getInt("status_id");
                    String statusName = rs.getString("status_name");
                    listStatus.put(statusId, statusName);
                }
                listStatus.put(0, "All");
            }
        } finally {
            closeConnection();
        }

    }

    public boolean updateStatusRequest(String requestId, int statusId) throws SQLException, NamingException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update dbo.request set status_id = ? where request_id = ?";
                ps = con.prepareStatement(sql);

                ps.setInt(1, statusId);
                ps.setString(2, requestId);

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

    public void getHistoryRequest(String requestName, String fromDate, String toDate, int memberId) throws SQLException, NamingException {
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
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select DISTINCT m.fullname,r.request_id, r.created_date, r.name, st.status_name \n"
                        + "from dbo.request r join dbo.members as m on r.members_id = m.member_id \n"
                        + "join dbo.status as st on r.status_id = st.status_id \n"
                        + "join dbo.request_resource as rr \n"
                        + "on rr.request_id = r.request_id\n"
                        + "join dbo.resource as rs \n"
                        + "on  rs.resource_id = rr.resource_id\n"
                        + "where r.name like ?\n "
                        + "and r.members_id = ?\n "
                        + "and r.created_date between ? and ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + requestName + "%");
                ps.setInt(2, memberId);
                ps.setDate(3, _fromDate);
                ps.setDate(4, _toDate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    Tbl_ListRequestDTO dto = new Tbl_ListRequestDTO();
                    dto.setRequestId(rs.getInt("request_id"));
                    dto.setRequestName(rs.getString("name"));
                    dto.setMemberNameRequest(rs.getString("fullname"));
                    dto.setDateRequest(rs.getString("created_date"));
                    dto.setStatusName(rs.getString("status_name"));
                    list.add(dto);
                }
            }

        } finally {
            closeConnection();
        }
    }
}
