function sendData() {

    $.ajax({
        url: "AddToCart",
        method: "POST",
        dataType: "html",
        data: $("#formCart").serialize(),
        success:function (){
            $("#exampleModal").modal("show");
        }

    })
}
