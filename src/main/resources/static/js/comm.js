//AES-128-CBC加密模式，key需要为16位，key和iv可以一样
//不补码方式 还需要引入pad-zeropadding-min.js文件
function encryptNoPadding(data) {
    var key  = CryptoJS.enc.Utf8.parse('dvyYRQlnPRCMdQSe');
    var iv   = CryptoJS.enc.Utf8.parse('face0123456789ai');
    console.log(CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding}).toString())
    return CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding}).toString();
}
//补码方式
function encryptPadding(data) {
    var key  = CryptoJS.enc.Utf8.parse('dvyYRQlnPRCMdQSe');
    var iv   = CryptoJS.enc.Utf8.parse('face0123456789ai');
    console.log(CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC}).toString())
    return CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC}).toString();
}
