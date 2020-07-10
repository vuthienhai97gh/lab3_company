<%-- 
    Document   : historybooking
    Created on : Jul 9, 2020, 10:24:48 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <!--If not EMPLOYEE OR LEADER-->
        <s:if test="%{#session.USER == null}">
            <h1>Please login first!</h1>
            <a href="login.jsp">To login page</a>
        </s:if>
        <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <h2>Manager can't go this page !!!</h2>
            <s:a action="logout">Logout</s:a><br/>
        </s:if>
        <!--If not EMPLOYEE OR LEADER-->

        <!--nếu là employee or leader-->
        <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <s:a action="logout">Logout</s:a><br/>
            <s:a href="search">Back to search</s:a>
                <h2>This is your booking history</h2>
                <font color="green"><s:property value="%{#request.CANCEL_STATUS}" /></font>
            <!--coi lịch sử booking-->
            <s:if test="%{#session.listBooking != null && !#session.listBooking.isEmpty()}">
                <table border="1" class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Total Category Booking</th>
                            <th>Total Quantity Booking</th>
                            <th>Booking Date</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{#session.listBooking}" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="" /></td>
                                <td><s:property value="" /></td>
                                <td><s:property value="" /></td>
                                <td>
                                    <s:form action="viewBookDetail" method="POST">
                                        <s:hidden name="bookId" value="%{bookId}" />
                                        <s:submit value="View Detail"/>
                                    </s:form>
                                </td>
                                <td>
                                    <s:url id="cancelLink" action="cancelBooking">
                                        <s:param name="bookId" value="%{bookId}" />
                                    </s:url>
                                    <s:a href="%{cancelLink}">Cancel</s:a>
                                    </td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <!--coi lịch sử booking-->
            <s:if test="%{#session.listBooking == null || #session.listBooking.isEmpty()}">
                <h2>Your order history is empty!</h2>
            </s:if><br/>
            <!--coi detail booking-->
            <s:if test="%{#session.listDetails != null || !#session.listDetails.isEmpty()}">
                <h2>Booking Detail</h2>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Category Name</th>
                            <th>Quantity</th>
                            <th>From Date</th>
                            <th>To Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{#session.listDetails}" status="counter2">
                            <tr>
                                <td><s:property value="%{#counter2.count}"/></td>
                                <td><s:property value="" /></td>
                                <td><s:property value="" /></td>
                                <td><s:property value="" /></td>
                                <td><s:property value="" /></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <!--coi detail booking-->
        </s:if>
        <!--nếu là employee or leader-->
    </body>
</html>
