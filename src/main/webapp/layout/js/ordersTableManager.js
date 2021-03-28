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
                    url: "OrdersServlet?action=load",
                    data: filter
                });
            }

        },
        fields: [
            //TODO Add Orders' fields
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
            {
                name: "userName",
                title: "Name",
                type: "text",
                editing: false,
                width: 60,
                validate: "required"
            },
            {
                name: "creditLimit",
                title: "Limit",
                type: "number",
                editing: false,
                validate: {
                    validator: "min",
                    message: "Product ID must be above 0",
                    param: 0
                },
                width: 50
            },
            {
                name: "email",
                title: "Email",
                type: "text",
                editing: false,
                width: 60,
                validate: "required"
            },
            {
                name: "job",
                title: "Job",
                type: "text",
                editing: false,
                width: 50,
                validate: "required"
            },
            {
                name: "birthday",
                title: "DOB",
                type: "text",
                editing: false,
                width: 50,
                validate: "required"
            },
            {
                name: "Role",
                title: "Role",
                type: "select",
                items: Roles,
                valueField: "Name",
                textField: "Name",
                width: 50,
                validate: "required"
            },
            {
                name: "userImg",
                title: "Image",
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

            {type: "control"}
        ]
    });

    // });
});