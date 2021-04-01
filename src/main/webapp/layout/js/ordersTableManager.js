$(function () {


    $("#jsGrid").jsGrid({
        height: "600",
        width: "100%",
        filtering: true,
        sorting: true,
        paging: true,
        autoload: true,
        pageSize: 20,
        pageButtonCount: 5,
        controller: {
            loadData: function (filter) {
                console.log(filter)
                return $.ajax({
                    type: "GET",
                    url: "OrdersServlet?action=load",
                    data: filter
                });
            }

        },
        fields: [
            {
                name: "id",
                title: "OrderId",
                type: "number",
                editing: false,
                align: "center",
                width: 50
            },
            {
                name: "email",
                title: "userEmail",
                type: "text",
                editing: false,
                align: "center",
                width: 60,
            },
            {
                name: "selectedAddress",
                title: "Delevery Address",
                type: "text",
                editing: false,
                align: "center",
                width: 80
            },
            {
                name: "purchaseDate",
                title: "Order Date",
                type: "text",
                editing: false,
                align: "center",
                width: 60,
            },

            {type: "control"}
        ]
    });

});