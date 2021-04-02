//页面加载完毕后
var nickname = null;
$(function (){

    //页面加载完毕后立即发送ajax请求，获取用户昵称
    $.ajax({
        url:"/user/findUserNickName",
        type:"get",
        dataType:"json",
        success:function(data){
            if(data.data != null){
                nickname = data.data.username;
                $("#nickname").html(nickname);
                $("#logout").html("退出");
                $("#regist").hide();
                $("#login").hide();
            }else{
                $("#regist").html("注册");
                $("#login").html("登录");
                $("#nickname").hide();
                $("#logout").hide();
            }
        }
    });
});