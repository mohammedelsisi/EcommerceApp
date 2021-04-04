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
                        inserting: false,
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
                        name: "prodDescription",
                        title: "Desc",
                        type: "textarea",
                        width: 50,
                        validate: "required",
                        css:"txt"
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
                        validate: function (value, item) {
                            return value.length > 0;
                        },
                        itemTemplate: function (val, item) {
                            this.currentimgVal = val;
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            this.insertForm = $("<form id='firstImgInsertForm'>").prop("method", "post").prop("enctype", "multipart/form-data");
                            this.insertControl = $("<input name='img'>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                            this.insertForm.empty().append(this.insertControl);
                            return this.insertForm;
                        },
                        insertValue: function () {
                            if (this.insertControl[0].files[0] != undefined) {
                                $("#firstImgInsertForm").submit(function (e) {
                                    e.preventDefault();
                                    var formData = new FormData(this);
                                    $.ajax({
                                        url: "ImageUpload",
                                        type: 'POST',
                                        data: formData,
                                        cache: false,
                                        contentType: false,
                                        processData: false
                                    });
                                });
                                $("#firstImgInsertForm").submit();
                                return "layout/images/products/" + this.insertControl[0].files[0].name;
                            }else return "";
                        },
                        editTemplate: function () {
                            this.updateForm = $("<form id='firstImgEditForm'>").prop("method", "post").prop("enctype", "multipart/form-data");
                            this.updatetControl = $("<input name='img'>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                            this.updateForm.empty().append(this.updatetControl);
                            return this.updateForm;
                        },
                        editValue: function () {
                            if (this.updatetControl[0].files[0] != undefined) {
                                $("#firstImgEditForm").submit(function (e) {
                                    e.preventDefault();
                                    var formData = new FormData(this);
                                    $.ajax({
                                        url: "ImageUpload",
                                        type: 'POST',
                                        data: formData,
                                        cache: false,
                                        contentType: false,
                                        processData: false
                                    });
                                });
                                $("#firstImgEditForm").submit();
                                return "layout/images/products/" + this.updatetControl[0].files[0].name;
                            } else return "";
                        },
                        align: "center",
                        width: 60
                    },
                    {
                        name: "secondProdImg",
                        title: "Img2",
                        validate: function (value, item) {
                            return value.length > 0;
                        },
                        itemTemplate: function (val, item) {
                            this.currentimgVal = val;
                            return $("<img>").attr("src", val).css({height: 50, width: 50});
                        },
                        insertTemplate: function () {
                            this.insertForm = $("<form id='secondImgInsertForm'>").prop("method", "post").prop("enctype", "multipart/form-data");
                            this.insertControl = $("<input name='img'>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                            this.insertForm.empty().append(this.insertControl);
                            return this.insertForm;
                        },
                        insertValue: function () {
                            if (this.insertControl[0].files[0] != undefined) {
                                $("#secondImgInsertForm").submit(function (e) {
                                    e.preventDefault();
                                    var formData = new FormData(this);
                                    $.ajax({
                                        url: "ImageUpload",
                                        type: 'POST',
                                        data: formData,
                                        cache: false,
                                        contentType: false,
                                        processData: false
                                    });
                                });
                                $("#secondImgInsertForm").submit();
                                return "layout/images/products/" + this.insertControl[0].files[0].name;
                            }else return "";
                        },
                        editTemplate: function () {
                            this.updateForm = $("<form id='secondImgEditForm'>").prop("method", "post").prop("enctype", "multipart/form-data");
                            this.updatetControl = $("<input name='img'>").prop("type", "file").prop("accept", ".jpg, .jpeg, .png");
                            this.updateForm.empty().append(this.updatetControl);
                            return this.updateForm;
                        },
                        editValue: function () {
                            if (this.updatetControl[0].files[0] != undefined) {
                                $("#secondImgEditForm").submit(function (e) {
                                    e.preventDefault();
                                    var formData = new FormData(this);
                                    $.ajax({
                                        url: "ImageUpload",
                                        type: 'POST',
                                        data: formData,
                                        cache: false,
                                        contentType: false,
                                        processData: false
                                    });
                                });
                                $("#secondImgEditForm").submit();
                                return "layout/images/products/" + this.updatetControl[0].files[0].name;
                            } else return "";
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
