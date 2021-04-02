$(function () {

    var MyDateField = function(config) {
        jsGrid.Field.call(this, config);
    };

    MyDateField.prototype = new jsGrid.Field({
        sorter: function(date1, date2) {
            return new Date(date1) - new Date(date2);
        },
        filterTemplate: function(value) {
            return this._filterPicker = $("<input>").datepicker({ defaultDate: new Date() });
        },
        filterValue: function() {
            if(this._filterPicker.datepicker("getDate") != null){
                var date2 = this._filterPicker.datepicker("getDate",'+1d');
                date2.setDate(date2.getDate()+1);
                return date2.toISOString().slice(0, 10).split("-").reverse().join("/");
            }
            else return "";
        }
    });
    jsGrid.fields.myDateField = MyDateField;

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
                type: "myDateField",
                editing: false,
                align: "center",
                width: 60,
            },

            { type: "control", editButton: false, modeSwitchButton: true, deleteButton:false }
        ]
    });

});