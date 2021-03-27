// function appendAddress() {
//
//
//     (function () {
//         'use strict'
//         // Fetch all the forms we want to apply custom Bootstrap validation styles to
//         var forms = document.querySelectorAll('.needs-validation')
//
//         // Loop over them and prevent submission
//         Array.prototype.slice.call(forms)
//             .forEach(function (form) {
//                 form.addEventListener('submit', function (event) {
//                     if (!form.checkValidity()) {
//                         event.preventDefault()
//                         event.stopPropagation()
//                     }
//
//                     form.classList.add('was-validated')
//                 }, false)
//             })
//     })()
//
//
//     var node = document.createElement("LI");
//
//     node.innerHTML = ('<input type="radio" id="newaddress" name="address" style="margin-top: 10%"> <label id="newAddressName" for="newaddress">' + document.getElementById("exampleInputAddress").value + '</label><!-- Divider --><hr class="sidebar-divider my-0">');
//
//     document.getElementById("Addresses").appendChild(node);
//
//     sendData();
// }
//
// function sendData() {
//
//     let newaddress = document.getElementById("exampleInputAddress").value;
//     console.log(newaddress);
//
//     $.ajax({
//         url: "Addresses",
//         method: "POST",
//         dataType: "html",
//         data: {"newAddress": newaddress}
//     })
// }
// //I cannot find Current user Addresses List !!
// window.onload = init;
// function init(){
//     document.getElementById('add').onclick = add;
// }
/*
function add(){
    var allAddresses = //sessionScope.currentUser.Addresses;
        var i;
    for (i=0;i<allAddresses.length;i++){
    var el = document.getElementById('Addresses');
    var node = document.createElement("li");
    var address = document.createElement("label");
    address.value = allAddresses[i];
    node.appendChild(address);
    el.appendChild(node);}
}
*/
