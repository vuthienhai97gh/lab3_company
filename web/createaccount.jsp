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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <s:head/>
    </head>
    <body>
<<<<<<< Updated upstream
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
    </body>
=======
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <span class="login100-form-title p-b-41">
                        Create New Account
                    </span>

                    <s:form action="createAccount" method="POST" cssClass="login100-form validate-form p-b-33 p-t-5">
                        <font color="green"><s:property value="%{#request.CREATE_STATUS}" /></font>
                        <s:textfield name="userId" label="Customer Email"/>
                        <!--                        <div class="wrap-input100 validate-input" data-validate = "Enter Email">
                                                    <input class="input100" type="text" name="userId" placeholder="User Email">
                                                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                                                </div>-->
                        <s:textfield name="name" label="Fullname" />
                        <!--                        <div class="wrap-input100 validate-input" data-validate = "Enter fullname">
                                                    <input class="input100" type="text" name="name" placeholder="Fullname">
                                                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                                                </div>-->
                        <s:password name="password" label="Password" />
                        <!--                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                                                    <input class="input100" type="password" name="password" placeholder="Password">
                                                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                                                </div>-->
                        <s:password name="confirmPassword" label="Confirm Password" />
                        <!--                        <div class="wrap-input100 validate-input" data-validate="Enter confirm password">
                                                    <input class="input100" type="password" name="confirmPassword" placeholder="Confirm Password">
                                                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                                                </div>-->
                        <s:textfield name="phone" label="Phone number" />
                        <!--                        <div class="wrap-input100 validate-input" data-validate="Enter phone number">
                                                    <input class="input100" type="text" name="phone" placeholder="Phone">
                                                    <span class="focus-input100"></span>
                                                </div>-->
                        <s:textfield name="address" label="Address" />
                        <!--                        <div class="wrap-input100 validate-input" data-validate="Enter label">
                                                    <input class="input100" type="text" name="address" placeholder="Address">
                                                    <span class="focus-input100"></span>
                                                </div>-->
                        <s:submit value="Create" cssClass="btn btn-primary"/>
                        <!--                        <div class="container-login100-form-btn m-t-32">
                                                    <button class="login100-form-btn">
                                                        Create
                                                    </button>
                                                </div>-->

                    </s:form>

                    <s:a href="login.jsp">Back to login</s:a>

                </div>
            </div>
            <div id="dropDownSelect1"></div>

            <!--===============================================================================================-->
            <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
            <!--===============================================================================================-->
            <script src="vendor/animsition/js/animsition.min.js"></script>
            <!--=======================
        </html>========================================================================-->
            <script src="vendor/bootstrap/js/popper.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
            <!--===============================================================================================-->
            <script src="vendor/select2/select2.min.js"></script>
            <!--===============================================================================================-->
            <script src="vendor/daterangepicker/moment.min.js"></script>
            <script src="vendor/daterangepicker/daterangepicker.js"></script>
            <!--===============================================================================================-->
            <script src="vendor/countdowntime/countdowntime.js"></script>
            <!--===============================================================================================-->
            <script src="js/main.js"></script>
    </body>

>>>>>>> Stashed changes
</html>
