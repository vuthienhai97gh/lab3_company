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
            <s:form action="searchHistoryRequest">
                <div class="content-search">
                    <s:textfield name="searchRequestNameHistory" label="Search Request"/><br/><br/>
                    <s:textfield name="fromDateRequest" type="date" label="Search From Date"/> 
                    <s:textfield name="toDateRequest" type="date" label="Search To Date"/><br/><br/>
                </div>
                <s:submit value="Search"/>
            </s:form>

            <table border="1" class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Request Name</th>
                        <th>Date Booking</th>
                        <th>Status</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{listRequestHistory}" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}"/></td>
                            <td><s:property value="requestName" /></td>
                            <td><s:property value="dateRequest" /></td>
                            <td><s:property value="statusName" /></td>
                            <s:if  test="statusName == 'New'">
                                <td><s:form action="deactiveRequest" method="POST">
                                        <input type="hidden" name="requestId" value="<s:property value="requestId" />" />
                                        <input type="submit" value="Delete" class="btn btn-primary"/>
                                    </s:form></td>
                                </s:if>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

            <s:if test="%{listRequestHistory == null}">
                Is Empty
            </s:if>
        </s:if>
    </body>
</html>
