/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import com.opensymphony.xwork2.ActionContext;
import haivt.accounts.Tbl_AccountDTO;
import haivt.list.request.Tbl_ListRequestDAO;
import haivt.list.request.Tbl_ListRequestDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vuthi
 */
public class SearchHistoryRequestAction {

    private final String SUCCESS = "success";
    private String searchRequestNameHistory;
    private String fromDateRequest;
    private String toDateRequest;

    public String getSearchRequestNameHistory() {
        return searchRequestNameHistory;
    }

    public void setSearchRequestNameHistory(String searchRequestNameHistory) {
        this.searchRequestNameHistory = searchRequestNameHistory;
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

    private List<Tbl_ListRequestDTO> listRequestHistory;

    public List<Tbl_ListRequestDTO> getListRequestHistory() {
        return listRequestHistory;
    }

    public void setListRequestHistory(List<Tbl_ListRequestDTO> listRequestHistory) {
        this.listRequestHistory = listRequestHistory;
    }

    public SearchHistoryRequestAction() {
    }

    public String execute() throws Exception {
        Tbl_ListRequestDAO dao = new Tbl_ListRequestDAO();
        Map session = ActionContext.getContext().getSession();
        Tbl_AccountDTO accountDTO = (Tbl_AccountDTO) session.get("USER");
        if (searchRequestNameHistory == null) {
            searchRequestNameHistory = "";
        }
        dao.getHistoryRequest(searchRequestNameHistory,  fromDateRequest, toDateRequest,accountDTO.getMemberId());
        listRequestHistory = dao.getList();
        return SUCCESS;
    }

}
