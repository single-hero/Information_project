/*since:2018.12.29 chenwenwei*/
var verifyCode = null;
$(function(){
    //初始化图形验证码
    verifyCode = new GVerify("codeCheckLogin");

    //键盘回车触发登录方法
    $(this).keydown(function (e) {
        if(e.which=='13'){
            SystemLogin();
        }
    })
});

//系统登陆
function SystemLogin(){
    //图形码验证验证(返回boolean类型)
    // var res=verifyCode.validate($("#checkNum").val());
    // if(!res){
    //     $("#checkNum").val("")
    //     errorSpop("验证码错误!")
    //     return
    // }
    // else{
        var loginName=$("#loginname").val();
        var password=$("#password").val();
        var data={loginname:loginName,psw:password,info:"Sys_backstage"};
        $.ajax({
            type:"POST",
            url:"/SysLogin/loginCheck",
            dataType:'json',
            cache:false,        //作用第一次请求完毕之后，可以直接从缓存里面读取而不是再到服务端读取
            data:{eParam:Encode(JSON.stringify(data))},
            success:function(data){
                if(data.state=="Success"){
                    // window.location=requestUrl()+"Index"
                    window.location="Index"
                }
                else {
                    document.getElementById("loginForm").reset();
                    verifyCode.refresh();
                    errorSpop("账号或密码错误!")
                }
                // console.log(Decode(data.result))
            },
            error:function(data){
                console.log(data)
                errorSpop("请稍候再试!!")
            }
        });
    // }
}
