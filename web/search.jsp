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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body
        <div class="container-fluid">
            Welcome, <font color="red">${sessionScope.USER.fullName}</font>
            <h1>Search Page</h1>
            <s:form action="search">
                <s:textfield name="searchResource" label="Search Resource"/>
                <s:submit value="Search"/>
            </s:form>

            <s:if test="%{list != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Resource Name</th>
                            <th>Quantity</th>
                            <th>Category Name</th>
                            <th>Color</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{list}">
                            <tr>
                                <td>
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
                                    <s:property value="date"/>
                                </td>
                            </tr>
                        </s:iterator>

                    </tbody>
                </table>
            </s:if>
            <s:if test="list == null and searchResource != null">
                <h2>
                    No Result found!!
                </h2>
            </s:if>
        </div>
    </body>
</html>
