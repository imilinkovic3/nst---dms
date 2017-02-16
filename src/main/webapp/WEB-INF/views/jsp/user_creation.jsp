<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <style type="text/css">
        <%@include file="../bootstrap/css/userinformation-popup.css"%>
    </style>
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

                        <c:choose>
                            <c:when test="${role.users.contains(user)}">
                                <input type="checkbox" name="role${role.id}" checked>${role.name}</input>
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="role${role.id}">${role.name}</input>

                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </td>
                <td>
                    <input type="button" id="edit_button${user.id}" value="Edit" class="edit"
                           onclick="edit_row('${user.id}')">
                    <input type="button" id="save_button${user.id}" value="Save" class="save"
                           onclick="save_row('${user.id}')">
                    <input type="button" id="delete_button${user.id}" value="Delete" class="delete"
                           onclick="delete_row('${user.id}')">
                    <input type="button" id="moredetails_button${user.id}" value="More details" class="moredetails"
                           onclick="more_details('${user.id}')">
                    <c:set var="selected_user" scope="request" value="${user}"/>
                </input>

                </td>
            </tr>

        </c:forEach>

        <tr>
            <td><input type="text" id="new_firstname"></td>
            <td><input type="text" id="new_username"></td>
            <td id="new_role">
                <c:forEach items="${roles}" var="role">

                    <input type="checkbox" name="role${role.id}">${role.name}</input>

                </c:forEach>
            </td>
            <td><input type="button" class="add" onclick="add_row();" value="Add Row"></td>
        </tr>

    </table>
</div>


<!-- The Modal -->
<div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">X</span>

        <form:form style="display: block;" id="edit-form" modelAttribute="user" action="/nst/login/edit/" method="post">

            <c:out value="${selected_user.id}"/>

            <table align='center' cellspacing=3 cellpadding=9 id="user_information_table">

                <tr>
                    <td>
                        <output type="text" id="user_id">User id</output>
                    </td>
                    <td >
                        <form:input path="id" type="text" id="user_id_value" value="${selected_user.id}" readonly="true"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_company">Company</output>
                    </td>
                    <td>
                        <form:input path="companyBean.name" type="text" id="user_company_value" value="${selected_user.companyBean.name}" readonly="true"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_firstname">Firstname</output>
                    </td>
                    <td><form:input path="firstname" type="text" id="user_firstname_edit" value="${selected_user.firstname}"/></td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_lastname">Lastname</output>
                    </td>
                    <td><form:input path="lastname" type="text" id="user_lastname_edit" value="${selected_user.lastname}"/></td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_email">Email</output>
                    </td>
                    <td><form:input path="email" type="text" id="user_email_edit" value="${selected_user.email}"/></td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_username">Username</output>
                    </td>
                    <td><form:input path="username" type="text" id="user_usrname_edit" value="${selected_user.username}"/></td>

                </tr>
                <tr>
                    <td>
                        <output type="text" id="user_roles">Roles</output>
                    </td>
                    <td >
                        <c:forEach items="${roles}" var="role">

                            <c:choose>
                                <c:when test="${role.users.contains(selected_user)}">
                                    <input type="checkbox" name="role${role.id}"  checked>${role.name}

                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="role${role.id}">${role.name}

                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </td>
                </tr>


            </table>
            <input type="submit" id="edit-submit" tabindex="4" value="SAVE"/>
        </form:form>


    </div>

</div>


</body>

<script>
    <%@include file="../../../js/userInformationPopup.js" %>

</script>


<script type="text/javascript"
        src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
    <%--<%@include file="../../../js/registerValidation.js"%>--%>
    <%@include file="../../../js/tableUsers.js" %>

</script>
</html>

