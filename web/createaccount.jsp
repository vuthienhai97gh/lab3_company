<%-- 
    Document   : register
    Created on : Jun 30, 2020, 5:36:55 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <s:head/>
    </head>
    <body>
        <div class="container-fluid">
        <h2>Create new account</h2>
        <font color="green"><s:property value="%{#request.CREATE_STATUS}" /></font>
        <s:form action="createAccount" method="POST">
            <s:textfield name="userId" label="Customer Email" />
            <s:textfield name="name" label="Fullname" />
            <s:password name="password" label="Password" />
            <s:password name="confirmPassword" label="Confirm Password" />
            <s:textfield name="phone" label="Phone number" />
            <s:textfield name="address" label="Address" />
            <s:submit value="Create" />
        </s:form>
        <s:a href="login.jsp">Back to login</s:a>
        </div>
    </body>
    
</html>
