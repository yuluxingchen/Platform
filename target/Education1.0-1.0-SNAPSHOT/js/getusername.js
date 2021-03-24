//页面加载完毕后
var nickname = null;
$(function (){
    //若点击搜索按钮则触发搜索功能
    $("#btn_search").on("click",function() {
        //123
        alert($("#btn_search").val());
    });

    //页面加载完毕后立即发送ajax请求，获取用户昵称
    $.ajax({
        url:"/user/findUserNickName",
        type:"get",
        dataType:"json",
        success:function(data){
            if(data.data != null){
                nickname = data.data.username;
                $("#nickname").html(nickname);
            }else{
                $("#regist").html("注册");
                $("#login").html("登录");
            }
        }
    });
});