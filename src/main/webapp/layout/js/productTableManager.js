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
                    var obj = {};
                    obj.l = list;
                    return obj;
                });
                Types = MetaData[0].l.map(function (list, index) {
                    var obj = {};
                    obj.Name = list;
                    return obj;
                });
                Sizes = MetaData[1].l.map(function (list, index) {
                    var obj = {};
                    obj.Name = list;
                    return obj;
                });
                Categories = MetaData[2].l.map(function (list, index) {
                    var obj = {};
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
                        console.log(filter);
                        return $.ajax({
                            type: "GET",
                            url: "ProductsServlet?action=load",
                            data: filter
                        });
                    },
                    insertItem: function (item) {
                        console.log(item)
                        return $.ajax({
                            type: "GET",
                            url: "ProductsServlet?action=insert",
                            data: item
                        });
                    },
                    updateItem: function (item) {
                        console.log(item);
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
                        width: 40
                    },
                    {
                        name: "firstProdImg",
                        title: "Img1",
                        itemTemplate: function (val, item) {
                            this.currentimgVal = val;
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            this.insertForm = $("<form id='firstImgForm'>").prop("method","post").prop("enctype","multipart/form-data");
                            this.insertControl = $("<input name='firstImg'>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                            this.insertForm.empty().append(this.insertControl);
                            return this.insertForm;
                        },
                        insertValue: function () {
                            if (this.insertControl[0].files[0] != undefined){
                                $("#firstImgForm").submit(function (e) {
                                    console.log("Submitting Img")
                                    e.preventDefault();
                                    var formData = new FormData(this);

                                    $.ajax({
                                        url: "firstImageUpload",
                                        type: 'POST',
                                        data: formData,
                                        success: function () {
                                            console.log("photo sent")

                                        },
                                        cache: false,
                                        contentType: false,
                                        processData: false
                                    });
                                });
                                $("#firstImgForm").submit();
                                console.log("sssss")
                                return "layout/images/products/" + this.insertControl[0].files[0].name;
                            }
                                // return this.insertForm.serialize();
                            //TODO add default Image
                            else return "layout/images/children.jpg";

                        },
                        editTemplate: function () {
                            return this.updatetControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        editValue: function () {
                            if (this.updatetControl[0].files[0] != undefined)
                                return "layout/images/" + this.updatetControl[0].files[0].name;
                            else
                                return this.currentimgVal;
                        },
                        align: "center",
                        width: 60
                    },
                    {
                        name: "secondProdImg",
                        title: "Img2",
                        itemTemplate: function (val, item) {
                            this.currentimgVal = val;
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            return this.insertControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        insertValue: function () {
                            if (this.insertControl[0].files[0] != undefined)
                                return "layout/images/" + this.insertControl[0].files[0].name;
                            else
                                return "layout/images/children.jpg";
                        },
                        editTemplate: function () {
                            return this.updatetControl = $("<input>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                        },
                        editValue: function () {
                            if (this.updatetControl[0].files[0] != undefined)
                                return "layout/images/" + this.updatetControl[0].files[0].name;
                            else
                                return this.currentimgVal;

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
                        width: 40
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
                        title: "category",
                        type: "select",
                        items: Categories,
                        valueField: "Name",
                        textField: "Name",
                        width: 50,
                        align: "center",
                        validate: "required"
                    },
                    {
                        name: "color",
                        title: "Color",
                        type: "text",
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
