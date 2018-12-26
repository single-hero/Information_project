$(function(){
    $('#loginModal').modal('show');
})

//系统登陆
function SystemLogin(){
    var loginName=$("#loginname").val();
    var password=$("#password").val();
    var data={loginname:loginName,psw:password}
    // console.log("======>>"+JSON.stringify(data))
    $.ajax({
        type:"POST",
        url:"/login/loginCheck",
        dataType:'json',
        cache:false,        //作用第一次请求完毕之后，可以直接从缓存里面读取而不是再到服务端读取
        data:{eParam:Encode(JSON.stringify(data))},
        success:function(data){
            console.log(data)
        },
        error:function(data){
            // $("body").append("<iframe scrolling='auto' frameborder='0'  src='"+data.responseText+"' style='width:100%' frameborder=0 allowfullscreen></iframe>");
            // $('#loginModal').modal('hide');
            console.log(data.responseText)
            console.log("失败")
        }
    })
}



   