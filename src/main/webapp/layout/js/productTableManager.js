$(function () {

    var Sizes = [];
    var Categories = [];
    var Types = [];

    $(function () {
        var Roles = [];
        $.ajax({
            type: "GET",
            url: "ProductsServlet?action=getMeta",
            success: function (response) {
                MetaData = response.map(function (list, index) {
                    var obj = new Object();
                    obj.l = list;
                    return obj;
                });
                Types = MetaData[0].l.map(function (list, index) {
                    var obj = new Object();
                    obj.Name = list;
                    return obj;
                });
                Sizes = MetaData[1].l.map(function (list, index) {
                    var obj = new Object();
                    obj.Name = list;
                    return obj;
                });
                Categories = MetaData[2].l.map(function (list, index) {
                    var obj = new Object();
                    obj.Name = list;
                    return obj;
                });
                console.log(Types);
                console.log(Sizes);
                console.log(Categories);
            },
            error: function () {
                console.log("error")
            }
        }).done(function () {

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
                        name: "prodID",
                        title: "ID",
                        type: "number",
                        editing: false,
                        validate: {
                            validator: "min",
                            message: "Product ID must be above 0",
                            param: 0
                        },
                        align: "center",
                        width: 60
                    },
                    {
                        name: "prodType",
                        title: "Type",
                        type: "select",
                        items: Types,
                        valueField: "Name",
                        textField: "Name",
                        width: 50,
                        validate: "required"
                    },
                    {
                        name: "prodQuantity",
                        title: "Qty",
                        type: "number",
                        validate: {
                            validator: "min",
                            message: "Quantity must be above 0",
                            param: 0
                        },
                        align: "center",
                        width: 50
                    },
                    {
                        name: "firstProdImg",
                        title: "Img1",
                        itemTemplate: function (val, item) {
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            return this.insertControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        insertValue: function () {
                            return "layout/images/" + this.insertControl[0].files[0].name;
                        },
                        editTemplate: function () {
                            return this.updatetControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        editValue: function () {
                            return "layout/images/" + this.updatetControl[0].files[0].name;
                        },
                        align: "center",
                        width: 60
                    },
                    {
                        name: "secondProdImg",
                        title: "Img2",
                        itemTemplate: function (val, item) {
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            return this.insertControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        insertValue: function () {
                            return "layout/images/" + this.insertControl[0].files[0].name;
                        },
                        editTemplate: function () {
                            return this.updatetControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        editValue: function () {
                            return "layout/images/" + this.updatetControl[0].files[0].name;
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
                        align: "center",
                        width: 50
                    },
                    {
                        name: "size",
                        title: "Size",
                        type: "select",
                        items: Sizes,
                        valueField: "Name",
                        textField: "Name",
                        width: 50,
                        align: "center",
                        validate: "required"
                    },
                    {
                        name: "category",
                        title: "categry",
                        type: "select",
                        items: Categories,
                        valueField: "Name",
                        textField: "Name",
                        width: 50,
                        align: "center",
                        validate: "required"
                    },
                    {type: "control"}
                ]
            })

        })
    })
});