$(function () {
    var Roles = [];
     $.ajax({
        type: "GET",
        url: "UsersServlet?action=getRoles",
         success:function (response){
            Roles = response.map( function(str, index) {
                var obj = new Object();
                obj.name = str;
                return obj;
            });

             console.log(Roles);

         },
         error:function (){
            console.log("error")
         }
    }).done(function (){

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
                         url: "UsersServlet?action=load",
                         data: filter
                     });
                 },
                 updateItem: function (item) {
                     return $.ajax({
                         type: "GET",
                         url: "UsersServlet?action=update",
                         data: item
                     });
                 },
                 deleteItem: function (item) {
                     return $.ajax({
                         type: "GET",
                         url: "UsersServle?action=delete",
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
                     align: "center",
                     width: 40
                 },
                 {
                     name: "userName",
                     title: "Name",
                     type: "text",
                     editing: false,
                     width: 60,
                     align: "center",
                     validate: "required"
                 },
                 {
                     name: "image",
                     title: "Image",
                     itemTemplate: function (val, item) {
                         return $("<img>").attr("src", val).css({height: 50, width: 50});
                     },
                     align: "center",
                     width: 50
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
                     align: "center",
                     width: 50
                 },
                 {
                     name: "email",
                     title: "Email",
                     type: "text",
                     editing: false,
                     width: 60,
                     align: "center",
                     validate: "required"
                 },
                 {
                     name: "phoneNumber",
                     title: "Phone",
                     type: "text",
                     editing: false,
                     width: 60,
                     align: "center",
                     validate: "required"
                 },
                 {
                     name: "Role",
                     title: "Role",
                     type: "select",
                     items: Roles,
                     valueField: "name",
                     textField: "name",
                     width: 50,
                     align: "center",
                     validate: "required"
                 },

                 {type: "control"}
             ]
         })

     });




    // });
});