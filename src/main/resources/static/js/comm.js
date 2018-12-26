//AES-128-CBC加密模式，key需要为16位，key和iv可以一样
//不补码方式 还需要引入pad-zeropadding-min.js文件
function encryptNoPadding(data) {
    var key  = CryptoJS.enc.Utf8.parse('6364737132303138');
    var iv   = CryptoJS.enc.Utf8.parse(systemKeyIv());
    return CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding}).toString();
}
//补码方式
function encryptPadding(data) {
    var key  = CryptoJS.enc.Utf8.parse('6364737132303138');
    var iv   = CryptoJS.enc.Utf8.parse(systemKeyIv());
    return CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC}).toString();
}

//进行base64编码
function base64Encode(data){
    return window.btoa(data)
}

//进行base64解码
function base64Decode(data){
    return window.atob(data)
}


//先进行aes加密后进行base64编码
function Encode(data) {
    var key  = CryptoJS.enc.Utf8.parse('6364737132303138');
    var iv   = CryptoJS.enc.Utf8.parse(systemKeyIv());
    //aes加密
    var aseEncode=CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC}).toString();
    //进行base64编码返回
    return base64Encode(aseEncode);
}

//获取系统时间(前6位)
function systemKeyIv() {
    return new Date().getTime().toString().substring(0,6)+"2018Encode";
}