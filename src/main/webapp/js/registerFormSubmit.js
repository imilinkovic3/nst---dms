function transformRegisterFormToJson() {
    var dataUser = JSON.stringify({
        "firstname": $("#firstname").val(),
        "lastname": $("#lastname").val(),
        "email": $("#email").val(),
        "username": $("#username").val(),
        "password": $("#password").val(),
        "roles": [{
            "id": "1",
            "name": "admin",
            "title": "admin"
        }],
        "companyBean": {
            "address": $("#address").val(),
            "city": $("#city").val(),
            "country": $("#country").val(),
            "fax": $("#fax").val(),
            "name": $("#companyName").val(),
            "phone": $("#phone").val(),
            "pib": $("#pib").val(),
            "postalcode": $("#postalCode").val()
        }
    });
    return dataUser;
}
function sendAjax() {
    // if ($('#register-form').valid()) {
    $.ajax({
        url: "/nst/confirmregistration/",
        type: 'POST',
        data: transformRegisterFormToJson(),
        contentType: 'application/json',
        success: function (data) {
            $('#mainBody').html(data);
        },
        error: function (data, status, er) {
            console.log(data + status + er);
            $('#emailError').html("Account with this email already exists");
        }
    });
    // }
}

// Trigger button on enter
$(document).ready(function(){
    $('#register-form').keypress(function(e){
        if(e.keyCode==13)
            $('#register-submit').click();
    });
});