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

function appendAddress() {

    var nodevalue = document.getElementById("exampleInputAddress").value;
    document.getElementById("exampleInputAddress").value = "";
    console.log(nodevalue);
    if (nodevalue != null && nodevalue !== '') {
        $.ajax({
            url: "Addresses",
            method: "POST",
            dataType: "JSON",
            data: {
                "newAddress": nodevalue
            },
            success: function (txt) {
                var address = document.getElementById("Addresses");
                address.innerHTML = "";
                txt.forEach(function (e) {
                    address.innerHTML += "    <li><label style=\"margin-top: 10%\">" + e + "</label>\n" +
                        "                                        <hr class=\"sidebar-divider my-0\">\n" +
                        "                                    </li>"
                })
            }

        })
    }

}



