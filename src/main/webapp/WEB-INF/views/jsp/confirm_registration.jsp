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
<body>
<form:form style="display: block;" id="login-form" action="/nst/register/"
           method="post">
    <div class="form-group col-sm-4 col-sm-offset-3">
        <h3> Please enter a received code </h3>
        <input type="text" name="code" id="code"
               placeholder="code" tabindex="2" class="form-control">
    </div>

    <div class="form-group">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-3">
                <input type="submit" id="register-submit" tabindex="4"
                       class="form-control btn btn-login" value="REGISTER"/>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>