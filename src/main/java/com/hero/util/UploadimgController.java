package com.hero.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 图片上传工具类
 * @author chenwenwei
 * @time 2018.12.25
 */
@RestController
@RequestMapping(value = "/Img")
public class UploadimgController {

    //服务器上传图片路径
    @Value(value = "${web.upload-path}")
    private String ThePath;


    @RequestMapping(value = "/tests")
    public @ResponseBody
    String test(){
        return "test";
    }

    //方法2
    @RequestMapping(value = "/uploadImg",method= RequestMethod.POST,produces="text/html;charset=utf-8")
    public @ResponseBody
    String upload(HttpServletRequest request) throws IOException {
        //图片名
        String uuidFileName="";
        //图片后缀
        String extName="";
        String PathUrl="upload/uploadImg";
//        String path =request.getSession().getServletContext().getRealPath("uploadImg");
        String path =ThePath+PathUrl;
//        String path=this.getClass().getClassLoader().getResource("/").getPath();
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
        System.out.println(multipartHttpServletRequest);
        Map<String,MultipartFile> map = multipartHttpServletRequest.getFileMap();
        //图片保存地址
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        try{
            for(Map.Entry<String,MultipartFile> entity:map.entrySet()){
                MultipartFile multipartFile=entity.getValue();
                //为了避免文件名重复,将文件修改为当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String Systime=df.format(System.currentTimeMillis());
                //获取上传图片名称及格式
                String name=multipartFile.getOriginalFilename();
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }
                File ff = new File(path,Systime+extName);
                //拼接新文件名
                uuidFileName = Systime+extName;
                multipartFile.transferTo(ff);

                //将图片同时上传到oss
                uploadOSSUtils ossUtils=new uploadOSSUtils();
                ossUtils.uploadFile(path+"/"+uuidFileName,uuidFileName);
            }
            return "/"+PathUrl+"/"+uuidFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "上传图片失败";
        }
    }


    @RequestMapping(value = "/uploadfile")
    public @ResponseBody
    String uploadfile(HttpServletRequest request){
        //文件名
        String uuidFileName="";
        //文件后缀
        String extName="";
        String name="";
        String PathUrl="upload/uploadfile";
//        String path =request.getSession().getServletContext().getRealPath("uploadfile");
        String path =ThePath+PathUrl;
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
        Map<String,MultipartFile> map = multipartHttpServletRequest.getFileMap();
        //文件保存地址
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        try{
            for(Map.Entry<String,MultipartFile> entity:map.entrySet()){
                MultipartFile multipartFile=entity.getValue();

                //为了避免文件名重复,将文件修改为当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String Systime=df.format(System.currentTimeMillis());
                //获取上传文件名称及格式
                name=multipartFile.getOriginalFilename();
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }

                File ff = new File(path,Systime+extName);
                //拼接新文件名
                uuidFileName = Systime+extName;
                multipartFile.transferTo(ff);

                //将文件同时上传到oss
                uploadOSSUtils ossUtils=new uploadOSSUtils();
                ossUtils.uploadFile(path+"/"+uuidFileName,uuidFileName);
            }
            return "/"+PathUrl+"/"+uuidFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "上传文件失败";
        }
    }


    @RequestMapping(value = "/uploadvideo")
    public @ResponseBody
    String uploadvideo(HttpServletRequest request){
        //视频名
        String uuidFileName="";

        //视频后缀
        String extName="";
        String name="";
        String PathUrl="upload/uploadvideo";
//        String path =request.getSession().getServletContext().getRealPath("uploadvideo");
//        String path=this.getClass().getClassLoader().getResource("/").getPath();
        String path =ThePath+PathUrl;
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
        Map<String,MultipartFile> map = multipartHttpServletRequest.getFileMap();
        //视频保存地址
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        try{
            for(Map.Entry<String,MultipartFile> entity:map.entrySet()){
                MultipartFile multipartFile=entity.getValue();

                //为了避免文件名重复,将文件修改为当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String Systime=df.format(System.currentTimeMillis());
                //获取上传图片名称及格式
                name=multipartFile.getOriginalFilename();
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }

                File ff = new File(path,Systime+extName);
                //拼接新视频名
                uuidFileName = Systime+extName;
                multipartFile.transferTo(ff);

                //将视频同时上传到oss
                uploadOSSUtils ossUtils=new uploadOSSUtils();
                ossUtils.uploadFile(path+"/"+uuidFileName,uuidFileName);
            }
            return "/"+PathUrl+"/"+uuidFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "上传新视失败";
        }
    }
}
