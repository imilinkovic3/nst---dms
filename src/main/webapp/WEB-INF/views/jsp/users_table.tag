<div id="wrapper">
    <table class="table" id="data_table">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
        </tr>
        <input type="hidden" id="rolesInput" name="roles" value="${roles}"/>
        <c:forEach items="${users}" var="user">
            <tr id="row${user.id}">
                <td id="rowId" hidden/>
                <td id="firstname_row${user.id}">${user.firstname}</td>
                <td id="lastname_row${user.id}">${user.lastname}</td>
                <td id="username_row${user.id}">${user.username}</td>

                <td class="btn-group-xs btn-group-horizontal">
                    <input type="button" id="edit_button${user.id}" value="Edit"
                           class="edit btn btn-primary btn-xs"
                           onclick="edit('${user.id}')">
                    <input type="button" id="delete_button${user.id}" value="Delete"
                           class="delete btn btn-primary btn-xs"
                           onclick="delete_row('${user.id}')">
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <input type="text" class="form-control" placeholder="Firstname" id="new_firstname">
                <label id="new_firstname_error" class="error" hidden="true"></label>
            </td>
            <td>
                <input type="text" class="form-control" placeholder="Lastname" id="new_lastname">
                <label id="new_lastname_error" class="error" hidden="true"></label>
            </td>
            <td>
                <input type="text" class="form-control" placeholder="Username" id="new_username">
                <label id="new_username_error" class="error" hidden="true"></label>
            </td>
            <td class="col-xs-3"><input type="button" class="add btn btn-success btn-xs btn-block" onclick="add_row();"
                                        value="Add Row"></td>
        </tr>
    </table>
</div>