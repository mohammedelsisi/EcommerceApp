function sendData() {
    let prodName= $("#item.prodName").val();
    let Quantity = $("#item.Quantity").val();

    console.log({"prodName": prodName, "Quantity": Quantity});
    $.ajax({
        url: "AddToCart",
        method: "POST",
        dataType: "html",
        data: $("#formCart").serialize(),
        success:function (){
            console.log("fuck fuck")
            $("#exampleModal").modal("show");
        }

    })
}
