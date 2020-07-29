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
<<<<<<< Updated upstream
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
                <font color="green"><s:property value="%{#request.DELETE_STATUS}" /></font>
=======
        <div class="container-fluid">
            <!--If EMPLOYEE OR LEADER-->
            <s:if test="%{#session.USER == null}">
                <h1>Please login first!</h1>
                <a href="login.jsp">To login page</a>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <h2>You can't go this page !!!</h2>
                <s:a action="logout">Logout</s:a><br/>
            </s:if>
            <!--If EMPLOYEE OR LEADER-->
            <!--nếu là manager-->
            <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <s:a action="logout">Logout</s:a><br/>
                <s:a href="search">Back to search</s:a>
                    <h2>This is request process</h2>
                    <font color="green"><s:property value="%{#request.DELETE_STATUS}" /></font>
>>>>>>> Stashed changes
                <font color="green"><s:property value="%{#request.ACCEPT_STATUS}" /></font>
                <s:form action="searchListRequest">
                    <div class="content-search">
                        <s:textfield name="searchResourceName" label="Search Resource"/><br/><br/>
                        <s:textfield name="fromDateRequest" type="date" label="Search From Date"/> 
                        <s:textfield name="toDateRequest" type="date" label="Search To Date"/><br/><br/>
                        <s:textfield name="searchUserRequest" label="Search User Request"/><br/><br/>
                        <s:hidden name="offset"/>
                        <s:if test="%{listStatus != null}">
                            <s:select label="Select Status"
                                      name="searchStatus"
                                      headerValue="Select Status"
                                      list="%{listStatus}"
                                      />
                        </s:if>
                    </div>
                    <s:submit value="Search" cssClass="btn btn-primary"/>
                </s:form>

                <!--coi request booking-->
                <s:if test="%{listRequest != null}">
                    <table border="1" class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>User Booking</th>
                                <th>Request Name</th>
                                <th>Booking Date</th>
                                <th>Status</th>
                                <th colspan="3">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="%{listRequest}" status="counter">
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="memberNameRequest" /></td>
                                    <td><s:property value="requestName" /></td>
                                    <td><s:property value="dateRequest" /></td>
                                    <td><s:property value="statusName" /></td>
                                    <s:if  test="statusName == 'New'">
                                        <td><s:form action="deleteRequest" method="POST">
                                                <input type="hidden" name="requestId" value="<s:property value="requestId" />" />
                                                <input type="hidden" name="requestName" value="<s:property value="requestName" />" />
                                                <input type="hidden" name="memberId" value="<s:property value="memberId" />" />
                                                <input type="submit" value="Delete" class="btn btn-primary"/>
                                            </s:form></td>
                                        </s:if>
                                        <s:if  test="statusName == 'New'">
                                        <td><s:form action="acceptRequest" method="POST">
                                                <input type="hidden" name="requestId" value="<s:property value="requestId" />" />
                                                <input type="hidden" name="requestName" value="<s:property value="requestName" />" />
                                                <input type="hidden" name="memberId" value="<s:property value="memberId" />" />
                                                <input type="submit" value="Accept" class="btn btn-primary"/>
                                            </s:form></td>
                                        </s:if>
                                    <td><s:form action="viewBookingDetailManage" method="POST">
                                            <input type="hidden" name="requestId" value="<s:property value="requestId" />" />
                                            <input type="hidden" name="memberId" value="<s:property value="memberId" />" />
                                            <input type="submit" value="Detail" class="btn btn-primary"/>
                                        </s:form></td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!--list detail-->
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

                </s:if>
                <!--list detail-->
                </s:if>
                <s:if test="%{listRequest == null}" >
                        <h1>Your request is empty</h1>
                    </s:if>
                <s:form action="searchListRequest" method="POST">
                    <s:hidden name="offset" value="%{#request.offset}"/>
                    <s:submit name="searchRequestBooking" value="Previous" cssClass="btn btn-primary"/>
                    <s:submit name="searchRequestBooking" value="Next" cssClass="btn btn-primary"/>
                </s:form>

                <!--coi request booking-->
                
            </s:if>
<<<<<<< Updated upstream
            <!--coi request booking-->
        </s:if>
        <!--nếu là manager-->
=======
            <!--nếu là manager-->
        </div>
>>>>>>> Stashed changes
    </body>
</html>
