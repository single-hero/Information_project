/*since:2018.12.29 chenwenwei*/
var verifyCode = null;
$(function(){
    $('#loginModal').modal('show');
    //初始化图形验证码
    verifyCode = new GVerify("codeCheckLogin");
})

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
        var data={loginname:loginName,psw:password,info:"Sys_backstage"}
        $.ajax({
            type:"POST",
            url:"/login/loginCheck",
            dataType:'json',
            cache:false,        //作用第一次请求完毕之后，可以直接从缓存里面读取而不是再到服务端读取
            data:{eParam:Encode(JSON.stringify(data))},
            success:function(data){
                if(data.state=="Success"){
                    successSpop("登陆成功");
                }
                else {
                    document.getElementById("loginForm").reset();
                    verifyCode.refresh();
                    errorSpop("账号或密码错误!")
                }
                // console.log(Decode(data.result))
            },
            error:function(data){
                // $("body").append("<iframe scrolling='auto' frameborder='0'  src='"+data.responseText+"' style='width:100%' frameborder=0 allowfullscreen></iframe>");
                // $('#loginModal').modal('hide');
                console.log(data)
                console.log("失败")
            }
        });
    // }
}
