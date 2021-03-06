<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<form:form id="register-form" style="display: none;"
           modelAttribute="user" name="register-form">

    <div class="form-group">
        <form:input path="firstname" type="text" name="firstname"
                    placeholder="Firstname" id="firstname" tabindex="1"
                    class="form-control" value=""/>
    </div>
    <div class="form-group">
        <form:input path="lastname" type="text" name="lastname"
                    placeholder="Lastname" id="lastname" tabindex="1"
                    class="form-control" value=""/>
    </div>
    <div class="control-group error" id="emailError"></div>

    <div class="form-group">
        <form:input path="email" type="email" name="email"
                    placeholder="Email" id="email" tabindex="1" class="form-control"/>
    </div>
    <div class="form-group">
        <form:input path="username" type="text" name="username"
                    placeholder="Username" id="username" tabindex="1"
                    class="form-control" value=""/>
    </div>
    <div class="form-group">
        <form:input path="password" type="password" name="password" placeholder="Password"
                    id="password" tabindex="2" class="form-control"/>
    </div>
    <%--<div class="form-group">--%>
    <%--<form:input path="" type="password" name="confirmPassword"--%>
    <%--placeholder="Confirm password" id="confirmPassword" tabindex="2"--%>
    <%--class="form-control"/>--%>
    <%--</div>--%>

    <%@include file="companyform.tag" %>

    <div class="form-group">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <button path="register-submit" type="button"
                        id="register-submit" tabindex="4"
                        class="form-control btn btn-register" onclick="sendAjax()">REGISTER
                </button>
            </div>
        </div>
    </div>
</form:form>