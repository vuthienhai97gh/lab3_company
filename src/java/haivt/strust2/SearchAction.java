/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.category.Tbl_CategoryDAO;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author vuthi
 */
public class SearchAction {

    private String searchResource;
    private String searchCategory;
    private String fromDate;
    private String toDate;
    private int start;
    private String offset;
    private String search;

    public String getOffset() {
        return offset;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    private List<Tbl_ResourceDTO> list;
    private Map<Integer, String> listCategory;
    private final String SUCCESS = "success";

    public SearchAction() {
    }

    public Map<Integer, String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(Map<Integer, String> listCategory) {
        this.listCategory = listCategory;
    }

    public String execute() throws Exception {
        Tbl_ResourceDAO dao = new Tbl_ResourceDAO();
        Tbl_CategoryDAO cateDao = new Tbl_CategoryDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (offset == null || offset.isEmpty()) {
            offset = "0";
        }
        if (search == null) {
            search = "";
        }
        int offsets = Integer.parseInt(offset);
        if (search.equals("Next")) {
            offsets += 1;
        } else if (search.equals("Previous")) {
            if (offsets > 0) {
                offsets -= 1;
            }
        }

        cateDao.getCategory();
        listCategory = cateDao.getListCategory();
        if (searchResource == null) {
            searchResource = "";
        }
        if (searchCategory == null) {
            searchCategory = "0";
        }
        dao.searchResource(searchResource, searchCategory, fromDate, toDate, offsets * 5, 5);
        list = dao.getList();
        request.setAttribute("offset", offsets);
        return SUCCESS;
    }

    public String getSearchResource() {
        return searchResource;
    }

    public void setSearchResource(String searchResource) {
        this.searchResource = searchResource;
    }

    public String getSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public List<Tbl_ResourceDTO> getList() {
        return list;
    }

    public void setList(List<Tbl_ResourceDTO> list) {
        this.list = list;
    }

}
