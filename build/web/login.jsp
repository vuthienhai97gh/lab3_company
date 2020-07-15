<%-- 
    Document   : login
    Created on : Jun 6, 2020, 4:39:13 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Login Page</h1>
            <form action="login" method="POST" class="container-fluid">
                <div class="form-group">
                    <label for="exampleInputEmail1">User name</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="username" placeholder="User Name">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                </div>
                <button type="submit" class="btn btn-primary" value="Login">Login</button>
                <input type="reset" value="Reset" class="btn btn-primary" /><br/><br/>
                <div class="g-recaptcha" data-sitekey="6LeUMqoZAAAAAFZGbLzF6fW1VDRLZmcXXM65EBje" ></div>
                <a href="createaccount.jsp">Click here to create an account</a>
            </form>

            <!--<a href="createNewAccount.jsp">Click here to Sign Up</a>-->
        </div>
    </body>
</html>
