<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
</head>
<body>
<div id="wrapper">
    <table align='center' cellspacing=3 cellpadding=9 id="data_table" border=1>
        <tr>
            <th>User</th>
            <th>Username</th>
            <th>Role</th>
        </tr>

        <c:forEach items="${users}" var="user">
            <tr id="row"${user.id}>
                <td id="firstname_row${user.id}">${user.firstname}</td>
                <td id="username_row${user.id}">${user.username}</td>
                <td id="role_row${user.id}">
                    <c:forEach items="${roles}" var="role">

                        <input type="checkbox" name="role${role.id}">${role.name}</input>

                    </c:forEach>
                </td>
                <td>
                    <input type="button" id="edit_button${user.id}" value="Edit" class="edit"
                           onclick="edit_row('${user.id}')">
                    <input type="button" id="save_button${user.id}" value="Save" class="save"
                           onclick="save_row('${user.id}')">
                    <input type="button" id="delete_button${user.id}" value="Delete" class="delete"
                           onclick="delete_row('${user.id}')">
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td><input type="text" id="new_firstname"></td>
            <td><input type="text" id="new_username"></td>
            <td><input type="text" id="new_role"></td>
            <td><input type="button" class="add" onclick="add_row();" value="Add Row"></td>
        </tr>

    </table>
</div>

</body>


<script type="text/javascript"
        src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
    <%--<%@include file="../../../js/registerValidation.js"%>--%>
    <%@include file="../../../js/tableUsers.js"%>

</script>
</html>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<form:form style="display: block;" id="login-form" action="/nst/login/"
           method="post">
    <div class="form-group">
        <input type="text" name="username" placeholder="Username"
               id="username" tabindex="1" class="form-control" value="">
    </div>
    <div class="form-group">
        <input type="password" name="password" id="password"
               placeholder="Password" tabindex="2" class="form-control">
    </div>
    <div class="form-group text-center">
        <input type="checkbox" tabindex="3" class="" name="remember"
               id="remember"> <label for="remember"> Remember Me</label>
    </div>
    <div class="form-group">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <input type="submit" id="login-submit" tabindex="4"
                       class="form-control btn btn-login" value="LOGIN"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="row">
            <div class="col-lg-12">
                <div class="text-center">
                    <a href="http://phpoll.com/recover" tabindex="5"
                       class="forgot-password">Forgot Password?</a>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group text-center">

    </div>
</form:form>