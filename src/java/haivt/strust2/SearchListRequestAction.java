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

/**
 *
 * @author vuthi
 */
public class SearchListRequestAction {

    private String searchResourceName;
    private String fromDateRequest;
    private String toDateRequest;
    private String searchStatus;
    private Map<Integer, String> listStatus;
    private List<Tbl_ListRequestDTO> listRequest;
    private final String SUCCESS = "success";

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
        listStatus = dao.getListStatus();
        if (searchResourceName == null) {
            searchResourceName = "";
        }
        if (searchStatus == null) {
            searchStatus = "0";
        }
        dao.getAllRequest(searchResourceName, fromDateRequest, toDateRequest, searchStatus);
        listRequest = dao.getList();
        return SUCCESS;
    }

}
