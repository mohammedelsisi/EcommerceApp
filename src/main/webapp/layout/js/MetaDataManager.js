$(function () {


    $("#jsGrid").jsGrid({
        height: "600",
        width: "100%",
        filtering: true,
        editing: true,
        sorting: true,
        paging: true,
        autoload: true,
        pageSize: 20,
        pageButtonCount: 5,
        controller: {
            loadData: function (filter) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsServlet?action=load",
                    data: filter
                });
            },
            insertItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsServlet?action=insert",
                    data: item
                });
            },
            updateItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsServlet?action=update",
                    data: item
                });
            },
            deleteItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsServlet?action=delete",
                    data: item
                });
            },
        },
        fields: [
            {
                name: "id",
                title: "ID",
                type: "number",
                editing: false,
                validate: {
                    validator: "min",
                    message: "Product ID must be above 0",
                    param: 0
                },
                width: 50
            },

            {type: "control"}
        ]
    });


});