/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author vuthi
 */
public class SearchAction {

    private String searchResource;
    private String searchCategory;
    private Date date;
    private List<Tbl_ResourceDTO> list;
    private final String SUCCESS = "success";

    public SearchAction() {
    }

    public String execute() throws Exception {
        Tbl_ResourceDAO dao = new Tbl_ResourceDAO();
        if(searchResource == null){
            searchResource = "";
        }
        
        dao.searchResource(searchResource, searchCategory, date);

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Tbl_ResourceDTO> getList() {
        return list;
    }

    public void setList(List<Tbl_ResourceDTO> list) {
        this.list = list;
    }

}
