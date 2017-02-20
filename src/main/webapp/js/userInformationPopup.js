// When the user clicks on <div>, open the popup, Get the modal
var modalInformations = document.getElementById('userInformationsPopup');
var modalConfirmation = document.getElementById('editConfirmationPopup');
// Get the <span> element that closes the modal
var spanInformationPopup = document.getElementById("closeInformationsPopup");
// Get the <span> element that closes the modal
var spanConfirmationPopup = document.getElementById("closeEditConfirmationPopup");
// When the user clicks on the button, open the modal
function edit(id) {
    getSelectedUser(id);
    // Setting value to hidden element of table. We will use this value to recognize which row fit on edited user
    document.getElementById("rowId").value = id;
    document.getElementById("confirmationType").value = "edit";
    modalInformations.style.display = "block";
}
// Trigger button on enter
$(document).ready(function () {
    $('#edit-form').keypress(function (e) {
        if (e.keyCode == 13)
            $('#edit-submit').click();
    });
});
function getSelectedUser(id) {
    $.ajax({
        url: "/nst/login/selectedUser/",
        type: 'POST',
        dataType: 'json',
        data: "id=" + id,
        cache: false,
        success: function (selectedUser) {
            document.getElementById('user_id_value').value = selectedUser.id;
            if (selectedUser.companyBean != null) {
                document.getElementById('user_company_value').value = selectedUser.companyBean.name;
            }
            document.getElementById('user_firstname_edit').value = selectedUser.firstname;
            document.getElementById('user_lastname_edit').value = selectedUser.lastname;
            document.getElementById('user_email_edit').value = selectedUser.email;
            document.getElementById('user_username_edit').value = selectedUser.username;
            document.getElementById('leftCorner').value = selectedUser.id + " - " + selectedUser.firstname + " " + selectedUser.lastname;
            return selectedUser;
        },
        error: function (data, status, er) {
            console.log(data + status + er);
        }
    });
}
function saveEditing() {
    modalConfirmation.style.display = "block";
}
function transformEditUserFormToJson() {
    var dataUser = JSON.stringify({
        "id": document.getElementById('user_id_value').value,
        "firstname": document.getElementById('user_firstname_edit').value,
        "lastname": document.getElementById('user_lastname_edit').value,
        "email": document.getElementById('user_email_edit').value,
        "username": document.getElementById('user_username_edit').value,
        "companyBean": {
            "name": document.getElementById('user_company_value').value
        }
    });
    return dataUser;
}
function editUser() {
    var user = transformEditUserFormToJson();
    $.ajax({
        url: "/nst/login/editUser/",
        type: 'POST',
        data: user,
        contentType: 'application/json',
        success: function (data) {
            var editedUserId = document.getElementById("rowId").value;
            $("#data_table").find('#firstname_row' + editedUserId).html(document.getElementById('user_firstname_edit').value);
            $("#data_table").find('#username_row' + editedUserId).html(document.getElementById('user_username_edit').value);
            $("#data_table").find('#lastname_row' + editedUserId).html(document.getElementById('user_lastname_edit').value);
        },
        error: function (data, status, er) {
            window.showModalDialog(data + " " + status + " " + er);
        }
    });
}
function deleteUser() {
    var id = document.getElementById("rowId").value;
    $.ajax({
        url: "/nst/user/delete/",
        type: 'POST',
        data: JSON.stringify(id),
        contentType: 'application/json',
        success: function () {
            console.log("Successfull deleting user!")
            document.getElementById("row" + id + "").outerHTML = "";
        },
        error: function () {
            // console.log(data + " " + status + " " + er);
            console.log("Unsuccessfully deleting user!")
        }
    });
}
function editConfirmationYes() {
    var confirmationType = document.getElementById('confirmationType').value;
    if (confirmationType === "edit") {
        editUser();
    } else if (confirmationType === "delete") {
        deleteUser();
    } else if (confirmationType === "addRow") {
        save_row();
    }
    modalConfirmation.style.display = "none";
    modalInformations.style.display = "none";
}
function editConfirmationNo() {
    modalConfirmation.style.display = "none";
}
// When the user clicks on <span> (x), close the modal
spanInformationPopup.onclick = function () {
    document.getElementById("edit-form").reset();
    modalInformations.style.display = "none";
}
spanConfirmationPopup.onclick = function () {
    modalConfirmation.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modalInformations) {
        modalInformations.style.display = "none";
    } else if ((event.target == modalConfirmation)) {
        modalConfirmation.style.display = "none";
    }
}