$(function () {

    // $.ajax({
    //     type: "GET",
    //     url: "/FashionStore_war_exploded/ProductsTable"
    // }).done(function () {

        $("#jsGrid").jsGrid({
            height: "600",
            width: "100%",
            filtering: true,
            editing: true,
            inserting: true,
            sorting: true,
            paging: true,
            autoload: true,
            pageSize: 20 ,
            pageButtonCount: 5,
            controller: {
                loadData: function (filter) {
                    return $.ajax({
                        type: "GET",
                        url: "ProductsTable",
                        data: filter
                    });
                }
            },
            fields: [

                {name: "prodID", title: "ID", type: "number", width: 60},
                {name: "prodType", title: "Type", type: "text",  width: 50},
                // {name: "prodDesc", title: "Desc", type: "textarea",  width: 50},
                {name: "prodQuantity", title: "Qty", type: "number",  width: 50},
                // {name: "firstProdImg", title: "Img1", type: "text",  width: 50},
                // {name: "secondProdImg", title: "Img2", type: "text",  width: 50},
                {name: "productPrice", title: "Price", type: "number",  width: 50},
                {name: "size", title: "Size", type: "text",  width: 50},
                {name: "category", title: "Cat", type: "text",  width: 50},
                {type: "control"}
            ]
        });

    // });
});