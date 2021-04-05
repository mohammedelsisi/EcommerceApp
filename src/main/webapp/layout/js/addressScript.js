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

// function Mysuccessfunction()
// {
//     var node = document.createElement("LI");
//
//     node.innerHTML = ('<label style="margin-top: 10%">${address}</label> <hr className="sidebar-divider my-0">')
//     document.getElementById("Addresses").appendChild(node);
//}
// function MyErrorfunction(text)
// {
//     var list = text.split(',');
//     $.each(list, function(index, value) {
//         alert(index + ': ' + value);
//     }
        function appendAddress() {

            if (nodevalue != null && nodevalue !== '') {
                $.ajax({
                    url: "Addresses",
                    data_type:"json",
                    method: "POST",
                    data: {
                        "newAddress": nodevalue
                    },
                    success : function(text)
                    {
                        console.log(text);
                       },
                    error: function () {
                        MyErrorfunction(text);
                    }
                });
            }
        }







