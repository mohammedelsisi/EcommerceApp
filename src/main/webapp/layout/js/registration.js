$(document).ready(function () {
    let emailInValid = $("#invalidEmailDiv");
    let emailValid = $("#validEmailDiv");
    let passValid = $("#validPass");
    let passInValid = $("#invalidPass");
    let emailField = $("#exampleInputEmail2");
    let passwordField = $("#exampleRepeatPassword")
    passwordField.keyup(checkPassword);
    $("#exampleInputPassword").keyup(checkPassword)
    emailField.bind("blur", checkEmail)
    function checkPassword(){
        if(passwordField.val()==$("#exampleInputPassword").val()){
            console.log("Validsss")
            passValid.css({"display": "block"});
            passInValid.css({"display": "none"});
            passwordField.addClass("validEmail")
            passwordField.removeClass("invalidEmail")
        }else {
            console.log("INNNN  Valid")
            passInValid.html("Passwords must match");
            passValid.css({"display": "none"});
            passInValid.css({"display": "block"});
            passwordField.addClass("invalidEmail")
            passwordField.removeClass("validEmail")
        }
    }

    function checkEmail() {
        if (isValidEmail(emailField.val())) {
            checkEmailServer();
        } else {
            inValidEmailUi("Email must be at format xx@xx.com")
        }
    }

    function checkEmailServer() {
        $.ajax({
            url: "CheckEmail",
            type: "POST",
            success: validateEmail,
            data: {
                email: emailField.val()
            },
        })
    }

    function validateEmail(result) {

        if (result == "Valid") {
            validEmailUI();
        } else {
            inValidEmailUi(" This Email has an account go to login >> <a href='Login'>Login</a>");
        }
    }

    function isValidEmail(email) {
        var patt = /\S+@\S+\.\S+/;

        return (patt.test(email));
    }

    function validEmailUI() {
        console.log("Valid")
        emailValid.css({"display": "block"});
        emailInValid.css({"display": "none"});
        emailField.addClass("validEmail")
        emailField.removeClass("invalidEmail")

    }

    function inValidEmailUi(data) {
        console.log("INNNN  Valid")
        emailInValid.html(data);
        emailValid.css({"display": "none"});
        emailInValid.css({"display": "block"});
        emailField.addClass("invalidEmail")
        emailField.removeClass("validEmail")
    }

    (function () {
        'use strict'


        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
});



