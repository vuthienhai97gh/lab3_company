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
<<<<<<< Updated upstream
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
=======
        <div class="container-fluid">
            <!--If not EMPLOYEE OR LEADER-->
            <s:if test="%{#session.USER == null}">
                <h1>Please login first!</h1>
                <a href="login.jsp">To login page</a>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <h2>Manager can't go this page !!!</h2>
                <s:a action="logout">Logout</s:a><br/>
            </s:if>
            <!--If not EMPLOYEE OR LEADER-->

            <!--nếu là employee or leader-->
            <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <s:a action="logout">Logout</s:a><br/>
                <s:a href="search">Back to search</s:a>
                    <h2>This is your booking history</h2>
                    <font color="green"><s:property value="%{#request.DELETE_STATUS}" /></font>
                <!--coi lịch sử booking-->
                <s:form action="searchHistoryRequest">
                    <div class="content-search">
                        <s:textfield name="searchRequestNameHistory" label="Search Request"/><br/><br/>
                        <s:textfield name="fromDateRequest" type="date" label="Search From Date"/> 
                        <s:textfield name="toDateRequest" type="date" label="Search To Date"/><br/><br/>
                        <s:hidden name="offset"/>
                    </div>
                    <s:submit value="Search" cssClass="btn btn-primary" />
                </s:form>
                <s:if test="%{listRequestHistory != null}">
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
                                    <td><s:form action="viewBookingDetail" method="POST">
                                            <input type="hidden" name="requestId" value="<s:property value="requestId" />" />
                                            <s:submit value="View Detail" cssClass="btn btn-info"/>
                                        </s:form></td>
                                        <s:if  test="statusName == 'New'">
                                        <td>
                                            <s:url action="deactiveRequest" id="delete">
                                                <s:param name="requestId" value="requestId" />
                                            </s:url>
                                            <s:a onclick="if (confirm('Are you sure?'))
                                                 commentDelete(1);
                                                 return false;" href="%{delete}" cssClass="btn btn-danger">Delete</s:a>
                                            </td>
                                    </s:if>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <s:if test="%{detailList != null}">
                        <h2>Booking Detail</h2>
                        <table border="1" class="table table-dark table-striped">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Resource Name</th>
                                    <th>Category Name</th>
                                    <th>Quantity</th>
                                    <th>Color</th>
                                    <th>From Date</th>
                                    <th>To Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="%{detailList}" status="counter">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <s:property value="resourceName"/>
                                        </td>
                                        <td>
                                            <s:property value="categoryName"/>
                                        </td>
                                        <td>
                                            <s:property value="quantity"/>
                                        </td>
                                        <td>
                                            <s:property value="colorName"/>
                                        </td>
                                        <td>
                                            <s:property value="fromDate"/>
                                        </td>
                                        <td>
                                            <s:property value="toDate"/>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
>>>>>>> Stashed changes

                    </s:if>
                    <!--list detail-->
                </s:if>
                <s:if test="%{listRequestHistory == null}">
                    <h1>List Request History is empty!!!</h1>
                </s:if>
                <s:form action="searchHistoryRequest" method="POST">
                    <s:hidden name="offset" value="%{#request.offset}" />
                    <s:submit name="search" value="Previous" cssClass="btn btn-primary"/>
                    <s:submit name="search" value="Next" cssClass="btn btn-primary"/>
                </s:form>
                <!--list detail-->

            </s:if>
<<<<<<< Updated upstream
        </s:if>
=======

        </div>
>>>>>>> Stashed changes
    </body>
</html>
