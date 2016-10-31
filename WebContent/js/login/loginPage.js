/**
 * Created by Administrator on 2016/3/10.
 */
window.onload = function()
{
    $(".connect p").eq(0).animate({"left":"0%"}, 600);
    $(".connect p").eq(1).animate({"left":"0%"}, 400);
}

$('#username').blur(function(){
    isLoginUserName($("#username").val())
})

$('#password').blur(function(){
    isPassword($("#password").val())
})

function isLoginUserName(userName) {
    var patrn = /[a-zA-Z0-9_]{4,17}$/;
    if (!patrn.exec(userName)) {
        $('#usernameMsg').html("请输入4-17字母或数字");
        // alert("输入有误");
    } else {
        $('#usernameMsg').html("");
    }
}

function isPassword(password){
    var patrn = /^[a-zA-Z]\w{5,17}$/;
    if(!patrn.exec(password)){
        $('#passwordMsg').html("请以字母开头输入5-17位密码");
       // alert('密码输入有误');
    }else {
        $('#passwordMsg').html("");
    }
}