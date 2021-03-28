function sendData() {

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
