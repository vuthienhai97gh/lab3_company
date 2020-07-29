<%-- 
    Document   : cart
    Created on : Jul 3, 2020, 2:05:31 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
<<<<<<< Updated upstream
        <s:if test="%{#session.USER == null}">
            <h1>Please login first!</h1>
            <a href="login.jsp">To login page</a>
        </s:if>

        <s:if test="%{#session.USER != null && #session.ROLE == 'MANAGER'}">
            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <h2>Only Employees and Leaders go to cart !!!!</h2>
            <s:a action="logout">Logout</s:a>
        </s:if>
        <s:if test="%{#session.USER != null && #session.ROLE != 'MANAGER'}">

            Welcome, <font color="red"><s:property value="%{#session.USER.fullName}" /></font>
            <s:a href="search">Back to search</s:a>

            <s:a action="logout">Logout</s:a><br/>
            <font color="green"><s:property value="%{#request.CART_STATUS}" /></font><br/>
            <s:form action="submitRequest" method="POST">
                Request Name:<s:textfield name="requestName"></s:textfield><br/>
                <s:submit value="Confirm" />
            </s:form>
=======
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
>>>>>>> Stashed changes

                Welcome, <font color="red"><s:property value="%{#session.USER.role}"/> - <s:property value="%{#session.USER.fullName}" /></font>
                <s:a action="logout">Logout</s:a><br/>
                <s:a href="search">Back to search</s:a><br/>
                    <h2>This is your Cart</h2>
                    <!--<font color="green"><s:property value="%{#request.CART_STATUS}" /></font><br/>-->

<<<<<<< Updated upstream
                            <td><s:property value="%{#counter.count}"/></td>
                            <td><s:property value="resourceDTO.resourceName" /></td>
                            <td><s:property value="%{quantity}" /></td>
                            <td><s:property value="resourceDTO.categoryName" /></td>
                            <td><s:property value="resourceDTO.colorName" /></td>
                            <td><s:a onclick="if (confirm('Are you sure?'))
                                 commentDelete(1);
                                 return false;" href="%{remove}">Remove</s:a></td>
                            </tr>
                    </s:iterator>
                </tbody>
            </table>
            <s:if test="%{#session.shoppingCart == null || #session.shoppingCart.isEmpty()}" >
                <h1>Your cart is empty</h1>
            </s:if>

        </s:if>

=======
                <s:if test="%{#session.shoppingCart != null}">
                    <font color="green"><s:property value="%{#request.CART_STATUS}" /></font><br/>
                    <table border="1" class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Resource Name</th>
                                <th>Category Name</th>
                                <th>Color</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="%{#session.shoppingCart}" status="counter">
                                <tr>

                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="resourceDTO.resourceName" /></td>
                                    <td><s:property value="resourceDTO.categoryName" /></td>
                                    <td><s:property value="resourceDTO.colorName" /></td>
                                    <td>
                                        <s:form action="updateCartItem" theme="simple">
                                            <s:hidden name="resourceId" value="%{resourceDTO.resourceId}" />
                                            <s:textfield type="number" name="quantity" value="%{quantity}" />
                                            <s:submit value="Update" cssClass="btn btn-primary"/>
                                        </s:form>
                                    </td>
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

                    <s:form action="submitRequest" method="POST" scssClass="needs-validation">
                        <div class="col-md-2 mb-2">
                            <input type="text" name="requestName" class="form-control" id="validationCustom01" placeholder="Request name"
                                   required>
                            <s:submit value="Confirm" cssClass="btn btn-primary"/></div>
                        </s:form>

                </s:if>
                <s:if test="%{#session.shoppingCart == null || #session.shoppingCart.isEmpty()}" >
                    <font color="red"><h3>Your cart is empty</h3></font>
                </s:if>

            </s:if>
        </div>
>>>>>>> Stashed changes

    </body>
</html>
