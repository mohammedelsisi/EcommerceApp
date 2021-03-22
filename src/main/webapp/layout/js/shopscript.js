var Prices=null;
(function () {
    'use strict';

    var init = function () {

        var slider = new rSlider({
            target: '#slider',
            values: [0,250, 500, 750, 1000, 1250, 1500, 1750, 2000],
            range: true,
            labels: false,
            set: [0, 2500],
            onChange: function (vals) {
                Prices = vals;
            }
        });
    };
    window.onload = init;
})();



function searchAndFilter(e){
    if(e.which===13){

        sendFilters();
        window.location.href="Shop?search="+$("#searchField").val();
    }



}

function sendFilters(){

    let colors= [];
    let sizes= [];
    let prices = Prices.split(",");
    $("input[name=Color]:checked").each(function (){
      colors.push(this.id)
    })
    $("input[name=Size]:checked").each(function (){
        sizes.push(this.id)
    })



    $.ajax({
        url:"Filter",
        method:"POST",
        data:{
            "colors":JSON.stringify(colors),
            "sizes":JSON.stringify(sizes),
            "minPrice":prices[0],
            "maxPrice":prices[1],
            "search":$("#searchField").val()
        },
        dataType: "html",
        success:function (txt){
            console.log(txt)
        }
    })

}

