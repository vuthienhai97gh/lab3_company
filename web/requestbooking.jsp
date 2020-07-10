<%-- 
    Document   : requestbooking
    Created on : Jul 9, 2020, 10:55:19 AM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Page</title>
    </head>
    <body>
        <!--If EMPLOYEE OR LEADER-->
        <s:if test="%{#session.USER == null}">
            <h1>Please login first!</h1>
            <a href="login.jsp">To login page</a>
        </s:if>
        <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <h2>You can't go this page !!!</h2>
            <s:a action="logout">Logout</s:a><br/>
        </s:if>
        <!--If EMPLOYEE OR LEADER-->
        <!--nếu là manager-->
        <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <s:a action="logout">Logout</s:a><br/>
            <s:a href="search">Back to search</s:a>
                <h2>This is request process</h2>

                <!--coi request booking-->
                <table border="1" class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>User Booking</th>
                            <th>Resource Name</th>
                            <th>Booking Date</th>
                            <th>Status</th>
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
                                    <s:form action="viewBookingDetail" method="POST">
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
                <s:if test="%{#session.shoppingCart == null || #session.shoppingCart.isEmpty()}" >
                    <h1>Your cart is empty</h1>
                </s:if>
            <!--coi request booking-->
        </s:if>
        <!--nếu là manager-->
    </body>
</html>
