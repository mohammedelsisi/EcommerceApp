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




    $("#ChosenUserimage").change(function () {
        readURL(this);
        $("#imageData").submit();
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
    let phone = $("#phoneNumber").val();
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
            "phoneNumber": phone,
            "creditLimit": creditLimit
        }

    })
}


function changePassword() {
    let changeDiv = $("#confirmChange");
    let currentPassword = $("#exampleInputNPassword").val();
    let newPassword = $("#exampleInputPassword").val();
    let confirmPassword = $("#exampleRepeatPassword").val();
    if (newPassword != confirmPassword) {
        changeDiv.html("new passwords must Match");
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
                changeDiv.html(receivedData);
                $("#registrationForm").trigger("reset");
            }

        })
    }
    $("#changePasswordModal").modal("hide")
    $("#changeInfoModal").modal("show")
}
