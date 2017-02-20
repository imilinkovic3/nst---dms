<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        <%@include file="../bootstrap/css/bootstrap-login.css"%>
        <%@include file="../bootstrap/css/bootstrap.css"%>
    </style>
    <title>Login</title>
</head>
<body id="mainBody">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="login">
                                <a href="#" class="active" id="login-form-link">Login</a>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="register">
                                <a href="#" id="register-form-link">Register</a>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <%@include file="loginform.jsp" %>
                            <%@include file="registerform.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript"
        src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
    <%@include file="../../../js/registerValidation.js"%>
    <%@include file="../../../js/login.js"%>
    <%@include file="../../../js/registerFormSubmit.js"%>
    <%@include file="../../../js/forgotPasswordPopup.js" %>
</script>
</html>