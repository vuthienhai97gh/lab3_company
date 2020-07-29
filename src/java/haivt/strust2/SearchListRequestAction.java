/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.list.request.Tbl_ListRequestDAO;
import haivt.list.request.Tbl_ListRequestDTO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class SearchListRequestAction {

    private String searchResourceName;
    private String searchUserRequest;
    private String fromDateRequest;
    private String toDateRequest;
    private String searchStatus;
    private Map<Integer, String> listStatus;
    private List<Tbl_ListRequestDTO> listRequest;
    private final String SUCCESS = "success";
    private String offset;
    private String searchRequestBooking;

    public String getSearchUserRequest() {
        return searchUserRequest;
    }

    public void setSearchUserRequest(String searchUserRequest) {
        this.searchUserRequest = searchUserRequest;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSearchRequestBooking() {
        return searchRequestBooking;
    }

    public void setSearchRequestBooking(String searchRequestBooking) {
        this.searchRequestBooking = searchRequestBooking;
    }

    public String getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }

    public Map<Integer, String> getListStatus() {
        return listStatus;
    }

    public void setListStatus(Map<Integer, String> listStatus) {
        this.listStatus = listStatus;
    }

    public String getFromDateRequest() {
        return fromDateRequest;
    }

    public void setFromDateRequest(String fromDateRequest) {
        this.fromDateRequest = fromDateRequest;
    }

    public String getToDateRequest() {
        return toDateRequest;
    }

    public void setToDateRequest(String toDateRequest) {
        this.toDateRequest = toDateRequest;
    }

    public String getSearchResourceName() {
        return searchResourceName;
    }

    public void setSearchResourceName(String searchResourceName) {
        this.searchResourceName = searchResourceName;
    }

    public List<Tbl_ListRequestDTO> getListRequest() {
        return listRequest;
    }

    public void setListRequest(List<Tbl_ListRequestDTO> listRequest) {
        this.listRequest = listRequest;
    }

    public SearchListRequestAction() {
    }

    public String execute() throws Exception {
        Tbl_ListRequestDAO dao = new Tbl_ListRequestDAO();
        dao.getStatusName();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (offset == null || offset.isEmpty()) {
            offset = "0";
        }
        if (searchRequestBooking == null) {
            searchRequestBooking = "";
        }
        int offsets = Integer.parseInt(offset);
        if (searchRequestBooking.equals("Next")) {
            offsets += 1;
        } else if (searchRequestBooking.equals("Previous")) {
            if (offsets > 0) {
                offsets -= 1;
            }
        }
        listStatus = dao.getListStatus();
        if (searchResourceName == null) {
            searchResourceName = "";
        }
        if (searchUserRequest == null) {
            searchUserRequest = "";
        }
        if (searchStatus == null) {
            searchStatus = "0";
        }
        dao.getAllRequest(searchResourceName, searchUserRequest, fromDateRequest, toDateRequest, searchStatus, offsets * 20, 20);
        listRequest = dao.getList();
        request.setAttribute("offset", offsets);
        return SUCCESS;
    }

}
