/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.resources.Tbl_CategoryDAO;
import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vuthi
 */
public class SearchAction {

    private String searchResource;
    private String searchCategory;
    private String fromDate;
    private String toDate;
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
        cateDao.getCategory();
        listCategory = cateDao.getListCategory();
        dao.searchResource(searchResource, searchCategory, fromDate, toDate);
        list = dao.getList();

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
