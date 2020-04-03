package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.JsonData;
import com.xinjingjie.picServer.bean.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {
//    private  final String filePath = System.getProperty("user.dir") + "/src/main/resources/static/appLocation";
    File directory = new File(".");
    private  final String filePath =directory.getCanonicalPath();
//            + "/src/main/resources/static/appLocation/";
    String fileName = null;//被下载文件的名称

    public FirstController() throws IOException {
    }

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("t1/index");

        return modelAndView;
    }


    @GetMapping(value = "/editDownload",produces = "application/json;charset=UTF-8")
    ModelAndView testGetMapping() {
        ModelAndView modelAndView = new ModelAndView("t1/1e5b536a-9270-430a-a69b-e8b7f974cc75");
        return modelAndView;
    }

    @PostMapping(value = "/upupup",produces = "application/json;charset=UTF-8")
    JsonData saveUser(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //file.isEmpty(); 判断图片是否为空
        //file.getSize(); 图片大小进行判断

        System.out.println("配置注入打印，文件路径为："+filePath);


        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        this.fileName=fileName;
        // 文件上传后的路径
        System.out.println("转换后的名称:"+fileName);

        File dest = new File(filePath + fileName);
        System.out.println("文件绝对路径"+dest.getPath());
        try {
            file.transferTo(dest);

            return new JsonData(0, fileName,dest.getAbsolutePath());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new JsonData(-1, "fail to save ", null);

    }


    @GetMapping(value = "/downloadFile",produces = "application/json;charset=UTF-8")
    private String downloadFile(HttpServletResponse response) {
        File file = new File(filePath+fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开            
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }


    @GetMapping("getAllUser")
    private List<User> getAllUser() {
        System.out.println("ssssssssssssss");
        List<User> list = new ArrayList<>();
        return list;
    }
    @GetMapping("/test")
    public Object sou(HttpServletRequest request) throws IOException {
        File directory = new File(".");
        System.out.println(directory.getCanonicalPath());
        return null;
    }
}
