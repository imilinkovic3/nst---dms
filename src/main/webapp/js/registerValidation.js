$(function () {
    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });

    $("form[name='register-form']").validate({
        rules: {
            firstname: "required",
            lastname: "required",
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                rangelength: [6, 12]
            },
            roleBean: "required",
            username: "required",
            confirmPassword: {
                required: true,
                equalTo: "#password"
            },
            "companyBean.pib" : "required",
            "companyBean.name" : "required",
            "companyBean.address" : "required",
            "companyBean.city" : "required",
            "companyBean.postalcode" : "required",
            "companyBean.country" : "required",
            "companyBean.fax" : "required",
            "companyBean.phone" : "required"
        },
        messages: {
            firstname: "Please enter your firstname",
            lastname: "Please enter your lastname",
            password: {
                required: "Please provide a password",
                rangelength: "Your password must be in the range 6-12"
            },
            email: {
                required: "Please enter email address",
                email: "Please enter a valid email address"
            },
            roleBean: "Please select at least one role",
            username: "Please enter your username",
            confirmPassword: {
                required: "Please provide a password",
                equalTo: "Passwords do not match"
            },
            "companyBean.pib" : "Please enter a pib",
            "companyBean.name" : "Please enter a name",
            "companyBean.address" : "Please enter a address",
            "companyBean.city" : "Please enter a city",
            "companyBean.postalcode" : "Please enter a postalcode",
            "companyBean.country" : "Please enter a country",
            "companyBean.fax" : "Please enter a fax",
            "companyBean.phone" : "Please enter a phone"
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});