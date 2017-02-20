<div id="userInformationsPopup" class="modal">
    <div class="modal-content">
        <span class="close" id="closeInformationsPopup">X</span>
        <input id="leftCorner" style="border:0px;" readonly="true"/>

        <form:form id="edit-form" modelAttribute="user">
            <hidden id="roles"/>
            <table align='center' id="user_information_table">
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_id">User id:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="id" type="text" id="user_id_value" readonly="true"/>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_company">Company:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="companyBean.name" type="text" id="user_company_value"
                                    readonly="true"/>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_firstname">Firstname:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="firstname" type="text" id="user_firstname_edit"/>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_lastname">Lastname:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="lastname" type="text" id="user_lastname_edit"/>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_email">Email:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="email" type="text" id="user_email_edit"/>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <output class="text-info" type="text" id="user_username">Username:</output>
                    </td>
                    <td class="form-group">
                        <form:input class="form-control" path="username" type="text" id="user_username_edit"/>
                    </td>
                </tr>
                <tr class="form-group" id="rolesRow">
                    <td class="form-group">
                        <output class="text-info" type="text" id="user_roles">Roles:</output>
                    </td>

                    <td class="form-group">
                        <select multiple="true" itemValue="id" itemLabel="name" id="roleSelect" class="form-control input-sm"/>
                    </td>

                    <%--<form:select path="roles" id="roles">--%>
                        <%--&lt;%&ndash;<form:option cssClass="none" value="${roles[0].name}">${roles[0].name}</form:option>&ndash;%&gt;--%>
                    <%--</form:select>--%>


                        <%--<td class="form-group">--%>
                        <%--<c:forEach items="${roles}" var="role">--%>
                        <%--<c:choose>--%>
                        <%--<c:when test="${selectedUser.roles.contains(role)}">--%>
                        <%--<input type="checkbox" name="role${role.id}" checked>${role.name}--%>
                        <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                        <%--<input type="checkbox" name="role${role.id}">${role.name}--%>
                        <%--</c:otherwise>--%>
                        <%--</c:choose>--%>
                        <%--</c:forEach>--%>
                        <%--</td>--%>
                </tr>
            </table>
            <button type="button" id="edit-submit" tabindex="4" class="btn btn-register" onclick="saveEditing();" value="save">Save
            </button>
        </form:form>
    </div>
</div>

<%@ include file="confirmation_popup.tag" %>
