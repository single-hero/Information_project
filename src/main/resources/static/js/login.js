$(function(){
    $('#loginModal').modal('show');
})

//系统登陆
function SystemLogin(){
    // encryptNoPadding('世界你好');

    var loginName=$("#loginname").val();
    var password=$("#password").val();
    var data={loginname:loginName,psw:password}
    // console.log(data)
    // console.log(JSON.stringify(data))
    // encryptPadding(JSON.stringify(data));
    $.ajax({
        type:"POST",
        url:"/login/loginCheck",
        dataType:'json',
        cache:false,        //作用第一次请求完毕之后，可以直接从缓存里面读取而不是再到服务端读取
        data:{eParam:encryptPadding(JSON.stringify(data))},
        success:function(data){
            console.log(data)
        },
        error:function(){
            console.log("失败")
        }
    })
}



   