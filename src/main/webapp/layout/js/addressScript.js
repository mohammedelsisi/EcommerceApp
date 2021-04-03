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

    var node = document.createElement("LI");
    var nodevalue =  document.getElementById("exampleInputAddress").value;
    node.innerHTML = ('<input type="radio" id="address1" name="address" style="margin-top: 10%"> <label for="address1">' + nodevalue + '</label><!-- Divider --><hr class="sidebar-divider my-0">');

    document.getElementById("Addresses").appendChild(node);

    console.log(nodevalue);
    $.ajax({
        url: "Addresses",
        method: "POST",
        dataType: "html",
        data: {
            "newAddress": nodevalue
        }

    })

}



