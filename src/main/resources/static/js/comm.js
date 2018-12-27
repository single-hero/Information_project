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
    //进行base64编码返回
    return Base64.encode(aseEncode);
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

//获取系统时间(前6位)
function systemKeyIv() {
    return new Date().getTime().toString().substring(0,6)+"2018Encode"+",6364737132303138";
}