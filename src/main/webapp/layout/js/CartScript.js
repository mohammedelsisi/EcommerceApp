let removedItems = [];

function removeRow(id) {
    document.getElementById(id).remove();
    console.log(id)
    removedItems.push(id);
    console.log(removedItems)
}

function updateAddTotal(valID, tdID, price) {
    var total = parseInt(document.getElementById(valID).value) + 1;
    document.getElementById(tdID).innerHTML = "$" + (total) * price;
    if (total <= 0) {
        document.getElementById(tdID).innerHTML = "$" + 0;
    }
}

function updateSubTotal(valID, tdID, price) {
    var total = parseInt(document.getElementById(valID).value) - 1;
    document.getElementById(tdID).innerHTML = "$" + (total) * price;
    if (total <= 0) {
        document.getElementById(tdID).innerHTML = "$" + 0;
        console.log(tdID)
        removeRow(tdID.substr(2))
    }
}

function sendCartItems() {


    let productIDs = [];
    let productQtns = [];
    var elemenst = document.querySelectorAll(".cartItem");
    console.log(elemenst.value);


    elemenst.forEach(function (e) {
        productIDs.push(+e.id.substr(7));
        productQtns.push(+e.value);
    })
    $.ajax({
        url: "UpdateCart",
        method: "POST",
        data: {
            "productIds": JSON.stringify(productIDs),
            "productQtn": JSON.stringify(productQtns),
            "removedItems": JSON.stringify(removedItems),
        },
        dataType: "html",

        success: function (txt) {
            console.log(txt)
        }

    })

}

function sumTotal() {

    var total = document.querySelectorAll(".totalItem");
    let x = 0;
    total.forEach(function (e) {
        console.log(e.innerHTML)
        x = x + (+(e.innerHTML.substr(1)));
    })

    $("#subTotal").html("$" + x + ".00")
    x=x+100;
    $("#total").html("$" + x + ".00")

}
sumTotal();
document.addEventListener("click", sumTotal);