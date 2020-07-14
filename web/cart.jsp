<%-- 
    Document   : cart
    Created on : Jul 3, 2020, 2:05:31 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <s:if test="%{#session.USER == null}">
                <h1>Please login first!</h1>
                <a href="login.jsp">To login page</a>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}"/></font>
                <h2>Only Employees and Leaders go to cart !!!!</h2>
                <s:a action="logout">Logout</s:a>
            </s:if>
            <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">
                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <s:a action="logout">Logout</s:a><br/>
                <s:a href="search">Back to search</s:a><br/>
                <h2>This is your Cart</h2>
                <font color="green"><s:property value="%{#request.CART_STATUS}" /></font><br/>
                <table border="1" class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Resource Name</th>
                            <th>Quantity</th>
                            <th>Category Name</th>
                            <th>Color</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{#session.shoppingCart}" status="counter">
                            <tr>

                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="resourceDTO.resourceName" /></td>
                                <td><s:property value="%{quantity}" /></td>
                                <td><s:property value="resourceDTO.categoryName" /></td>
                                <td><s:property value="resourceDTO.colorName" /></td>
                                <td>
                                    <s:url action="removeFromCart" id="remove">
                                        <s:param name="resourceId" value="resourceDTO.resourceId" />
                                    </s:url>
                                    <s:a onclick="if (confirm('Are you sure?'))
                                     commentDelete(1);
                                     return false;" href="%{remove}" cssClass="btn btn-primary">Remove</s:a></td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>
                <s:form action="submitRequest" method="POST" theme="simple" cssClass="well form-search">
                   <s:textfield name="requestName" placeholder="Request Name"/><br/><br/>
                    <s:submit value="Confirm" cssClass="btn btn-primary"/>
                </s:form>
                <s:if test="%{#session.shoppingCart == null || #session.shoppingCart.isEmpty()}" >
                    <h1>Your cart is empty</h1>
                </s:if>
            </s:if>
        </div>
    </body>
</html>
