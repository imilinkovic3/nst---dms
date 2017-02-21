function delete_row(id) {
    document.getElementById("confirmationType").value = "delete";
    document.getElementById("rowId").value = id;
    modalConfirmation.style.display = "block";
}

function add_row() {
    document.getElementById("confirmationType").value = "addRow";
    var new_firstname = document.getElementById("new_firstname").value;
    var new_lastname = document.getElementById("new_lastname").value;
    var new_username = document.getElementById("new_username").value;


    if (!new_firstname) {
        $('#new_firstname_error').html("* Please provide firstname").delay(1000).fadeOut();
        $('#new_firstname_error').show();
        return;
    } else {
        $('#new_firstname_error').hide();
    }


    if (!new_lastname) {
        $('#new_lastname_error').html("* Please provide lastname").delay(1000).fadeOut();
        $('#new_lastname_error').show();
        return;
    } else {
        $('#new_lastname_error').hide();
    }


    if (!new_username) {
        $('#new_username_error').html("* Please provide username").delay(1000).fadeOut();
        $('#new_username_error').show();
        return;
    } else {
        $('#new_username_error').hide();
    }


    modalConfirmation.style.display = "block";
}

function save_row() {
    var new_firstname = document.getElementById("new_firstname").value;
    var new_username = document.getElementById("new_username").value;
    var new_lastname = document.getElementById("new_lastname").value;

    // var table = document.getElementById("data_table");
    // var table_len = (table.rows.length) - 1;

    // Setting value to hidden element of table. We will use this value to recognize which row fit on selected user
    // document.getElementById("rowId").value = table_len;

    save_new_user(new_firstname, new_lastname, new_username);

    // var row = table.insertRow(table_len).outerHTML =
    //     "<tr id='row" + table_len + "'>" +
    //     "<td id='firstname_row" + table_len + "'>" + new_firstname + "</td>" +
    //     "<td id='lastname_row" + table_len + "'>" + new_lastname + "</td>" +
    //     "<td id='username_row" + table_len + "'>" + new_username + "</td>" +
    //     "<td>" +
    //     " <input type='button' id='edit_button" + table_len + "' value='Edit' class='edit btn btn-primary btn-xs' onclick='edit(" + table_len + ")'>" +
    //     " <input type='button' value='Delete' class='delete btn btn-primary btn-xs' onclick='delete_row(" + table_len + ")'>" +
    //     "</td>" +
    //     "</tr>";

    document.getElementById("new_firstname").value = "";
    document.getElementById("new_username").value = "";
    document.getElementById("new_lastname").value = "";
}

function transformRowUserToJson(new_firstname, new_lastname, new_username) {
    var dataUser = JSON.stringify({
        "firstname": new_firstname,
        "lastname": new_lastname,
        "username": new_username,
    });
    return dataUser;
}

function save_new_user(new_firstname, new_lastname, new_username) {
    var user = transformRowUserToJson(new_firstname, new_lastname, new_username);
    $.ajax({
        url: "/nst/login/editUser/",
        type: 'POST',
        data: user,
        contentType: 'application/json',
        success: function (data) {
            location.reload();
        },
        error: function (data, status, er) {
            console.log(data + " " + status + " " + er);
        }
    });
}