/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.strust2;

import haivt.resources.Tbl_ResourceDAO;
import haivt.resources.Tbl_ResourceDTO;
import java.util.List;

/**
 *
 * @author vuthi
 */
public class ViewBookingDetailAction {

    private String memberId;
    private int requestId;
    private List<Tbl_ResourceDTO> detailList;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public List<Tbl_ResourceDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Tbl_ResourceDTO> detailList) {
        this.detailList = detailList;
    }


    public ViewBookingDetailAction() {
    }

    public String execute() throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();
        Tbl_ResourceDAO bookingDetailDAO = new Tbl_ResourceDAO();
        bookingDetailDAO.getListResourceByRequestId(requestId);
        detailList = bookingDetailDAO.getList();
//        session.put("listDetails", detailList);
        return "success";
    }

}
