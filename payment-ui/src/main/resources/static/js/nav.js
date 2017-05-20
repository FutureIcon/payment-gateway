/**
 * Created by Administrator on 2015/12/14.
 */
$(function(){
    var _isMobile = /android|ipad|iphone|midp|rv:1.2.3.4|ucweb|windows ce|windows mobile/i.test(navigator.userAgent); //true：移动设备
    //移动适配
    $(".header .nav button").bind("click",function(){
        var isShow = $(this).attr("data-isshow");
        if(isShow == "false"){
            $(".header .nav .loginbar,.header .nav ul").addClass("show");
            $(this).attr("data-isshow","true");
        }else{
            $(".header .nav .loginbar,.header .nav ul").removeClass("show");
            $(this).attr("data-isshow","false");
        }
    });
    //导航 更多
    if(_isMobile){
        $(".header .nav ul li.more").bind("click",function(){
            $(this).find("div").toggle();
        })
    }

    $("#demo").bind("click", function(){
        $.ajax({
            type:"POST",
            url:"/common/data/demo.php",
            data:{},
            datatype: "json",
            success:function(data){
                data = JSON.parse(data);
                //if(data.resultCode == 0){
                //    location.href = "/dashboard/";
                //}
                location.href = "/dashboard/";
            },
            error: function(){
                alert("error");
            }
        });
    });
});