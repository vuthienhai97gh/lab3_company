<%-- 
    Document   : register
    Created on : Jun 30, 2020, 5:36:55 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <s:form action="createAccount">
            <s:textfield name="userId" label="User Name"></s:textfield>
            <s:password name="password" label="Password"></s:password>
            <s:textfield name="name" label="Full Name"></s:textfield>
            <s:textfield name="phone" label="Phone Number"></s:textfield>
            <s:textfield name="address" label="Address"></s:textfield>
            <%--<s:textfield name="OTP Code" label="OTP Code"></s:textfield>--%>
            <%--<s:textfield name="email" label="Email"></s:textfield>--%>
            <%--<s:radio list="{'male','female'}" name="gender"></s:radio>--%>
            <%--<s:select cssStyle="width:155px;"list="{'vietnam','anh','nuockhac',}" name="country" label="Country"></s:select>--%>

            <s:submit value="Create"></s:submit>

        </s:form>
    </body>
</html>
