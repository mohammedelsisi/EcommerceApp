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


    $('.nav-item').on('click', function () {
        var isAlreadySelected = $(this).hasClass('background_selected');
        $('.nav-item').removeClass('background_selected');
        if (!isAlreadySelected) {
            $(this).addClass('background_selected');
        }
    });


    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#UserImage').css('background-image', 'url(' + e.target.result + ')');
                $('#UserImage').hide();
                $('#UserImage').fadeIn(650);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#ChosenUserimage").change(function () {
        readURL(this);
        $("#imageData").submit();
    });

    $("#my_form").submit(function (event) {
        event.preventDefault(); //prevent default action
        var post_url = $(this).attr("action"); //get form action url
        var request_method = $(this).attr("method"); //get form GET/POST method
        var form_data = $(this).serialize(); //Encode form elements for submission

        $.ajax({
            url: post_url,
            type: request_method,
            data: form_data
        }).done(function (response) { //
            $("#server-results").html(response);
        });
    });

    $("#imageData").submit(function (e) {
        e.preventDefault();
        var formData = new FormData(this);

        $.ajax({
            url: "uploadImage",
            type: 'POST',
            data: formData,
            success: function () {
                console.log("photo sent")

            },
            cache: false,
            contentType: false,
            processData: false
        });
    });
})();


function sendData() {
    let userName = $("#usernameInputExample").val();
    let birthDate = $("#userDateId").val();
    let userJob = $("#userJobId").val();
    let creditLimit = $("#exampleInputCreditLimit").val();
    console.log({"userName": userName, "date": birthDate, "job": userJob, "creditLimit": creditLimit});
    console.log({"userName": userName, "date": birthDate, "job": userJob, "creditLimit": creditLimit});
    $.ajax({
        url: "EditingUser",
        method: "POST",
        dataType: "html",
        data: {
            "userName": userName,
            "birthDate": birthDate,
            "job": userJob,
            "phone": "+201027579113",
            "creditLimit": creditLimit
        }

    })
}


function changePassword() {
    let currentPassword = $("#exampleInputNPassword").val();
    let newPassword = $("#exampleInputPassword").val();
    let confirmPassword = $("#exampleRepeatPassword").val();
    if (newPassword != confirmPassword) {
        console.log("Passwords must Match")
    } else {


        $.ajax({
            url: "changePassword",
            method: "POST",
            dataType: "html",
            data: {
                "currentPassword": currentPassword,
                "newPassword": newPassword,
                "confirmPassword": confirmPassword,
            },
            success:function (receivedData){

               console.log(receivedData)
            }

        })
    }
}
