<%-- 
    Document   : login
    Created on : Jun 6, 2020, 4:39:13 PM
    Author     : vuthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" integrity="sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd" crossorigin="anonymous"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://apis.google.com/js/api.js" async defer></script>
<meta name="google-signin-client_id" content="355097093788-0k5c0m04o7qpkc2ncn2gd11mtoc85k9k.apps.googleusercontent.com">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
    </head>
    <body>
        <!--<div class="container-fluid">-->
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <span class="login100-form-title p-b-41">
                        Account Login
                    </span>
                    <s:form action="login" method="POST" cssClass="login100-form validate-form p-b-33 p-t-5">

                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <input class="input100" type="text" name="username" placeholder="User name">
                            <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>

                        <font color="red"><s:property value="%{#request.ERROR}"/></font><br/>
                        <div class="container-login100-form-btn m-t-32">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>
                        <div class="container-login100-form-btn m-t-32">

                            <div class="g-recaptcha" data-sitekey="6LeUMqoZAAAAAFZGbLzF6fW1VDRLZmcXXM65EBje"></div><br/>
                            <font color="red"><s:property value="%{#request.ERRORCAPTCHA}"/></font><br/><br/>
                        </div>

                        <div class="container-login100-form-btn m-t-32">
                            <div class="g-signin2" data-onsuccess="onSignIn" id="myP" ></div>
                            <img id="myImg"><br>
                            <p id="name"></p>
                            <div id="status">
                            </div>
                            <script type="text/javascript">
                                function onSignIn(googleUser) {
                                    var profile = googleUser.getBasicProfile();
                                    window.location.href = 'loginGoogle?username=' + profile.getEmail();
                                }
                            </script>
                        </div>
                        <div class="container-login100-form-btn m-t-32">
                            <a href="createaccount.jsp">Click here to create an account</a>
                        </div>
                    </div>
                </s:form><br/>

            </div>
        </div>
    </div>
    <div id="dropDownSelect1"></div>

    <!--===============================================================================================-->
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
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
</html>
