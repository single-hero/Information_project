/*since:2018.12.29 chenwenwei*/
//AES-128-CBC加密模式，key需要为16位，key和iv可以一样
//加密
function getAesEncode(data,key,iv){
    var key  = CryptoJS.enc.Utf8.parse(key);
    var iv   = CryptoJS.enc.Utf8.parse(iv);
    var encrypted =CryptoJS.AES.encrypt(data,key,
        {
            iv:iv,
            mode:CryptoJS.mode.CBC,
            padding:CryptoJS.pad.Pkcs7
        });
    return encrypted.toString();
}
//解密
function getAesDecode(encrypted,key,iv){
    var key  = CryptoJS.enc.Utf8.parse(key);
    var iv   = CryptoJS.enc.Utf8.parse(iv);
    var decrypted =CryptoJS.AES.decrypt(encrypted,key,
        {
            iv:iv,
            mode:CryptoJS.mode.CBC,
            padding:CryptoJS.pad.Pkcs7
        });
    return decrypted.toString(CryptoJS.enc.Utf8);
}

//先进行aes加密后进行base64编码
function Encode(data) {
    var key  = systemKeyIv().split(",")[1];
    var iv   = systemKeyIv().split(",")[0];
    //aes加密
    var aseEncode=getAesEncode(data,key,iv);
    //base64加密
    var Base64Encode =Base64.encode(aseEncode);
    console.log("====>>"+Base64Encode)
    // console.log(insertStr(insertStr(insertStr(insertStr(Base64Encode,18,"2"),27,"0"),39,"1"),48,"9"));
    //base64简单加盐返回
    return insertStr(insertStr(insertStr(insertStr(Base64Encode,18,"2"),27,"0"),39,"1"),48,"9");
}

//先进行base64解码后进行aes解密
function Decode(data){
    var key  = systemKeyIv().split(",")[1];
    var iv   = systemKeyIv().split(",")[0];
    //进行base64解码
    var base64Decode=Base64.decode(data);
    //进行aes解密返回
    return getAesDecode(base64Decode,key,iv);
}

//在固定位置插入符号(start为将要插入字符的位置，newStr为要插入的字符)
function insertStr(soure, start, newStr){
    return soure.slice(0, start) + newStr + soure.slice(start);
}

//获取系统时间(前6位)
function systemKeyIv() {
    return new Date().getTime().toString().substring(0,6)+"2018Encode"+",6364737132303138";
}


//http+域名+端口
function requestUrl() {
    var jumpUrl = "";
    var url = document.location.toString();
    var arrUrl = url.split("//");
    // http 或者 https
    var http = arrUrl[0];
    var askURL = arrUrl[1].split("/");
    // 域名+端口
    var domain = askURL[0];
    var start = askURL[1].split("/");
    // 项目名
    var projectName = start[0];

    jumpUrl = http + "//" + domain + "/" + projectName;
    return jumpUrl;
}

//SmallPop提示框架配置
//错误提示
function errorSpop(hint) {
    spop({
        template:hint,
        position:"top-center",  //提示位置
        group: 'submit-satus',  //每个组只能有一个小pop
        style:'error',
        autoclose: 5000     //停留时间
    });
}

//成功
function successSpop(hint) {
    spop({
        template:hint,
        position:"top-center",  //提示位置
        group: 'submit-satus',  //每个组只能有一个小pop
        style:'success',
        autoclose: 2000     //停留时间
    });
}

//警告
function warningSpop(hint) {
    spop({
        template:hint,
        position:"top-center",  //提示位置
        group: 'submit-satus',  //每个组只能有一个小pop
        style:'warning',
        autoclose: 5000     //停留时间
    });
}
//默认提示
function defaultSpop(hint) {
    spop({
        template:hint,
        position:"top-center",  //提示位置
        group: 'submit-satus',  //每个组只能有一个小pop
        autoclose: 3000     //停留时间
    });
}