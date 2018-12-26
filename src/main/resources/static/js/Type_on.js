function autoType(elementClass, typingSpeed){
  var thhis = $(elementClass);
  thhis.css({
    "position": "relative",
    "display": "inline-block"
  });
    thhis.prepend('<div class="cursor" style="right: initial; left:0;"></div>');
  thhis = thhis.find(".text-js");
  var text = thhis.text().trim().split('');
  var amntOfChars = text.length;
  var newString = "";
  thhis.text("|");
  setTimeout(function(){
    thhis.css("opacity",1);
    thhis.prev().removeAttr("style");
    thhis.text("");
    for(var i = 0; i < amntOfChars; i++){
      (function(i,char){
        setTimeout(function() {
          newString += char;
          thhis.text(newString);
        },i*typingSpeed);
      })(i+1,text[i]);
    }
  },1200);
}
//打字速度
$(document).ready(function(){
  autoType(".type-js",100);
});



var time = 4; //时间,秒
var timelong = 0;
function diplaytime(){ //时间递减
    document.all.his.innerHTML = time -timelong ;
    timelong ++;
}
function redirect(){ //跳转页
    // $(".text-show").css('display','block');
    window.location.href="Login.templates";//指定要跳转到的目标页面
}
timer=setInterval('diplaytime()', 1300);//显示时间
timer=setTimeout('redirect()',time * 1300); //跳转
