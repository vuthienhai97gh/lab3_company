<%-- 
    Document   : search
    Created on : Jun 26, 2020, 12:56:04 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="355097093788-0k5c0m04o7qpkc2ncn2gd11mtoc85k9k.apps.googleusercontent.com">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <s:head/>
    </head>
    <body
        <div class="container-fluid">
            <s:if test="%{#session.USER == null}">
                <font color="red">Only Login can search!!!</font><br/>
                <a href="login.jsp">Click here to Login !!!</a>
            </s:if>
            <s:if test="%{#session.USER != null}">
<<<<<<< Updated upstream
                Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
                <s:a action="logout">Logout</s:a><br/>
                <font color="green"><s:property value="%{#request.CART_STATUS}" /></font>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
                <a href="cart.jsp">View My Cart</a>
                <a href="historybooking.jsp">My booking history</a>
=======
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <button onclick="signOut()" class="btn btn-primary">Sign Out</button><br/>
                <script>

                    function signOut() {
                        gapi.load('auth2', function () {
                            auth2 = gapi.auth2.init({
                                client_id: '355097093788-0k5c0m04o7qpkc2ncn2gd11mtoc85k9k.apps.googleusercontent.com',
                                fetch_basic_profile: false,
                                scope: 'profile'
                            });
                        });
                        var auth2 = gapi.auth2.getAuthInstance();
                        auth2.signOut().then(function () {

                        });
                        window.location.href = '/Lab3_Company/logout.action';
                    }

                </script>
                <font color="green"><s:property value="%{#request.CART_STATUS}" /></font>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
                <a href="cart.jsp">View My Cart</a> - 
                <s:a action="searchHistoryRequest">My booking history</s:a>
>>>>>>> Stashed changes
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
                <s:a action="searchListRequest">List Request Booking</s:a>
            </s:if>

<<<<<<< Updated upstream
            <!--paging-->
            <s:set var="totalCount" value="%{list.size()}"/>
            <s:set var="perPage"  value="2"/>
            <s:set var="pageStart" value="0"/>

            <s:if test="%{start > 0}">
                <s:set var="test" value="%{start}"/>
                <s:set var="pageStart"  value="%{#test}"/>
            </s:if>
            <s:if test="%{#totalCount < #pageStart}">
                <s:set var="pageStart" value="%{#pageStart - #perPage}"/>
            </s:if>
=======
>>>>>>> Stashed changes

            <s:if test="%{#session.USER != null}">
                <h1>Search Page</h1>
<<<<<<< Updated upstream
                <s:form action="search">
                    <div class="content-search">
                        <s:textfield name="searchResource" label="Search Resource"/><br/><br/>
                        <s:textfield name="fromDate" type="date" label="Search From Date"/> 
                        <s:textfield name="toDate" type="date" label="Search To Date"/><br/><br/>


                        <s:if test="%{listCategory != null}">
                            <s:select label="Select Category"
                                      name="searchCategory"
                                      headerValue="Select Category"
                                      list="%{listCategory}"
                                      />
                        </s:if>
                    </div>
                    <s:submit value="Search"/>
=======
                <s:form action="search" theme="simple" cssClass="well form-search">
                    <!--<div class="content-search">-->
                    <s:textfield name="searchResource" label="Search Resource" placeholder="Input Resource Name"/><br/><br/>
                    <s:textfield name="fromDate" type="date" label="Search From Date" /> - 
                    <s:textfield name="toDate" type="date" label="Search To Date"/><br/><br/>

                    <s:hidden name="offset"/>
                    <s:if test="%{listCategory != null}">
                        <s:select label="Select Category"
                                  name="searchCategory"
                                  headerValue="Select Category"
                                  list="%{listCategory}"
                                  />
                    </s:if><br/><br/>
                    <!--</div>-->
                    <s:submit value="Search" cssClass="btn btn-primary"/>
>>>>>>> Stashed changes
                </s:form>
                <s:if test="%{list != null}">
                    <table border="1" class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Resource Name</th>
                                <th>Quantity</th>
                                <th>Category Name</th>
                                <th>Color</th>
                                <th>From Date</th>
                                <th>To Date</th>
                                    <s:if test="%{#session.ROLE != 'MANAGER'}">
                                    <th>Booking</th>
                                    </s:if>
                            </tr>
                        </thead>
                        <tbody>

                            <s:iterator value="%{list}" status="counter">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="resourceName"/>
                                    </td>
                                    <td>
                                        <s:property value="quantity"/>
                                    </td>
                                    <td>
                                        <s:property value="categoryName"/>
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
                                    <td>
                                        <s:if test="%{#session.ROLE != 'MANAGER'}">
                                            <s:form action="addToCart" method="POST">
                                                <input type="hidden" name="memberId" value="<s:property value="%{#session.USER.user_id}" />" />
                                                <input type="hidden" name="resourceId" value="<s:property value="resourceId" />" />
                                                <input type="submit" value="Book This" class="btn btn-primary"/>
                                            </s:form>
                                        </s:if>

                                    </td>

                                </tr>
                            </s:iterator>

                        </tbody>
                    </table>

                </s:if>
                <s:if test="list == null and searchResource != null">
                    <h2>
                        <font color="red">No Result found!!</font>
                    </h2>
                </s:if>
                <s:form action="search" method="POST">
                    <s:hidden name="offset" value="%{#request.offset}"/>
                    <s:submit name="search" value="Previous" cssClass="btn btn-primary"/>
                    <s:submit name="search" value="Next" cssClass="btn btn-primary"/>

                </s:form>

            </s:if>
        </div>
    </body>
</html>
