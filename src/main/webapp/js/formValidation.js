$(document).ready(function () {
        $('#login-form').formValidation({
        	framework: 'bootstrap',        
        	feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    validators: {
                        notEmpty: {
                            message: 'Username nije unet'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'Password nije unet'
                        }
                    }
                }
            }
        })
    });