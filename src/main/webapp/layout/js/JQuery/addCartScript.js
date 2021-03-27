function sendData() {
    let prodName= $("#item.prodName").val();
    let Quantity = $("#item.Quantity").val();

    console.log({"prodName": prodName, "Quantity": Quantity});
    $.ajax({
        url: "AddToCart",
        method: "POST",
        dataType: "html",
        data: {
            "prodName": prodName,
            "Quantity": Quantity
        }

    })
}
