$(function () {

    var Sizes = [
        { Name: "", Id: 0 },
        { Name: "Small", Id: 1 },
        { Name: "Medium", Id: 2 },
        { Name: "Large", Id: 3 }
    ];
    var Categories = [
        { Name: "", Id: 0 },
        { Name: "Men", Id: 1 },
        { Name: "Women", Id: 2 },
        { Name: "Children", Id: 3 }
    ];
    var Types = [
        { Name: "", Id: 0 },
        { Name: "T-Shirt", Id: 1 },
        { Name: "T-Shirt", Id: 2 },
        { Name: "T-Shirt", Id: 3 }
    ];

    $("#jsGrid").jsGrid({
        height: "600",
        width: "100%",
        filtering: true,
        editing: true,
        inserting: true,
        sorting: true,
        paging: true,
        autoload: true,
        pageSize: 20,
        pageButtonCount: 5,
        controller: {
            loadData: function (filter) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsTable?action=load",
                    data: filter
                });
            },
            insertItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsTable?action=insert",
                    data: item
                });
            },
            updateItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsTable?action=update",
                    data: item
                });
            },
            deleteItem: function (item) {
                return $.ajax({
                    type: "GET",
                    url: "ProductsTable?action=delete",
                    data: item
                });
            },
        },
        fields: [

            {
                name: "prodID",
                title: "ID",
                type: "number",
                editing: false,
                validate: {
                    validator: "min",
                    message: "Product ID must be above 0",
                    param: 0
                },
                width: 60
            },
            {name: "prodType", title: "Type", type: "select", items: Types, valueField: "Name", textField: "Name", width: 50,validate: "required" },
            {
                name: "prodQuantity",
                title: "Qty",
                type: "number",
                validate: {
                    validator: "min",
                    message: "Quantity must be above 0",
                    param: 0
                },
                width: 50
            },
            {
                name: "firstProdImg",
                title: "Img1",
                itemTemplate: function (val, item) {
                    return $("<img>").attr("src", val).css({height: 50, width: 50});
                },
                insertTemplate: function () {
                    return  this.insertControl = $("<input>").prop("type", "file").prop("accept",".jpg, .jpeg, .png");
                },
                insertValue: function () {
                    return "layout/images/"+this.insertControl[0].files[0].name;
                },
                editTemplate: function () {
                    return  this.updatetControl = $("<input>").prop("type", "file").prop("accept",".jpg, .jpeg, .png");
                },
                editValue: function () {
                    return "layout/images/"+this.updatetControl[0].files[0].name;
                },
                align: "center",
                width: 60
            },
            {
                name: "secondProdImg",
                title: "Img2",
                itemTemplate: function(val, item) {
                    return $("<img>").attr("src", val).css({ height: 50, width: 50 });
                },
                insertTemplate: function() {
                    return  this.insertControl = $("<input>").prop("type", "file").prop("accept",".jpg, .jpeg, .png");
                },
                insertValue: function() {
                    return "layout/images/"+this.insertControl[0].files[0].name;
                },
                editTemplate: function () {
                    return  this.updatetControl = $("<input>").prop("type", "file").prop("accept",".jpg, .jpeg, .png");
                },
                editValue: function () {
                    return "layout/images/"+this.updatetControl[0].files[0].name;
                },
                align: "center",
                width: 60
            },
            {
                name: "productPrice",
                title: "Price",
                type: "number",
                validate: {
                    validator: "min",
                    message: "Quantity must be above 0",
                    param: 0
                },
                width: 50
            },
            {name: "size", title: "Size", type: "select", items: Sizes, valueField: "Name", textField: "Name", width: 50,validate: "required" },
            {name: "category", title: "categry", type: "select", items: Categories, valueField: "Name", textField: "Name", width: 50,validate: "required" },
            {type: "control"}
        ]
    });

    // });
});