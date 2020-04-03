package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.Picture;
import com.xinjingjie.picServer.impl.PicImpl;
import com.xinjingjie.picServer.impl.UserImpl;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class FileSaveUtil {

    private static FileSaveUtil INSTANCE;

    public static FileSaveUtil getINSTANCE(UserImpl userImpl,PicImpl picImpl) {
        if (INSTANCE==null){
            INSTANCE=new FileSaveUtil(userImpl,picImpl);
        }
        return INSTANCE;
    }

    public FileSaveUtil(UserImpl userImpl, PicImpl picImpl) {
        this.userImpl = userImpl;
        this.picImpl = picImpl;
    }

    private  UserImpl userImpl;
    private  PicImpl picImpl;
//    static String hostAddress = "http://112.124.44.175:80/";

    static String hostAddress = "http://192.168.2.107:8080/";

    private  final String filePath = System.getProperty("user.dir") + "/src/main/resources/static/";
    public  String saveFile(MultipartFile file, HttpServletRequest request,String  type){

        int user_id = Integer.parseInt(request.getParameter("uid"));
        System.out.println(user_id);
        System.out.println(userImpl==null);
        if (user_id != 0 && !userImpl.isExist(user_id)) {
            return  "未找到用户！";
        }
            //file.isEmpty(); 判断图片是否为空
            //file.getSize(); 图片大小进行判断
            if (file.isEmpty()) {
                return "图片为空！";
            }
            if (file.getSize() > 10485760) {
                return "图片太大！";
            }

            System.out.println("file size==" + file.getSize());



        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:" + fileName);
        File dest=null;
        //如果是上传的图片的话
        if ("PostImage".equals(type)){
            String username=userImpl.findUsernameById(user_id);
            String contents = request.getParameter("contents");
            String tags = request.getParameter("tags");
            System.out.println("用户名ID：" + user_id);

            // 文件上传后的路径

            String username_md5 = DigestUtils.md5DigestAsHex(String.valueOf(user_id).getBytes());
             dest = new File(filePath +"/image/"+ username_md5 + "/" + fileName);
//   InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
            //  String hostAddress = address.getHostAddress();

            String location =  hostAddress + "/image/" + username_md5 + "/" + fileName;
            System.out.println(location);
            System.out.println(new Date());
            Picture picture = new Picture(user_id, username, new Date(), location, 0, 0, contents, tags, userImpl.findProfilePic(user_id));

            picImpl.add(picture);
            userImpl.setPic_numberAdd(user_id);

        }else if ("backgroundImage".equals(type))
        {

            dest = new File(filePath +"/backgroundPic/"+ fileName);
            String location =  hostAddress + "/backgroundPic/"  + fileName;
            userImpl.updateBackGroundPic(user_id, location);
        }else
            /*if ("profileImage".equals(type))*/
        {
            System.out.println("--------------------------------------------------------------edit peofilepICTURE");
            dest = new File(filePath +"/profilePicture/"+  fileName);
            String location =  hostAddress + "/profilePicture/"  + fileName;
            userImpl.updateProfilePic(user_id, location);
        }
            try {
                System.out.println(dest.getParentFile());
                if (!dest.getParentFile().exists()) {
                    System.out.println("dest ParentFile Don't ExIST");
                    if (dest.getParentFile().mkdirs()){
                        System.out.println("success");
                    }else {
                        System.out.println("wrong");
                    };
                }else{
                    System.out.println("dest ParentFile Don't ExIST");

                }

                file.transferTo(dest);
                System.out.println("success!");
                return "success";
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            return "error";

    }
}
