package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.JsonData;
import com.xinjingjie.picServer.bean.User;
import com.xinjingjie.picServer.impl.PicImpl;
import com.xinjingjie.picServer.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserImpl userImpl;
    @Autowired
    private PicImpl picImpl;

    @PostMapping("add")
    public JsonData add(User user) {
        if (user.getTelephone() == null || user.getUsername() == null) {
            return new JsonData(-1, "信息未填写完整");
        } else if (!userImpl.getPhoneUnique(user.getTelephone())) {
            return new JsonData(-1, "该号码已存在！");
        } else {
            user.setCreate_time(new Date());
            user.setPic_number(0);
            if (userImpl.add(user) == 1) {
                return new JsonData(0, "插入成功");
            } else
                return new JsonData(-1, "出错了");
        }
    }

    @GetMapping("testSend")
    public JsonData<User> testSend(String name, String pwd) {
        System.out.println("name:" + name + ",password:" + pwd);
        User user = userImpl.findByPhone(name);
        if (user != null) {
            return new JsonData<User>(0, "SUCCESS", user);
        } else
            return new JsonData(-1, "FAILED");


    }

    @PostMapping("testRegister")
    public JsonData testRegister(@RequestBody User user) {
        System.out.println("telephone" + user.getTelephone());
        System.out.println("username" + user.getUsername());
        System.out.println("password" + user.getPassword());
        System.out.println("createTime" + user.getCreate_time());

        if (user.getTelephone() == null || user.getUsername() == null) {
            return new JsonData(-1, "信息未填写完整");
        } else if (!userImpl.getPhoneUnique(user.getTelephone())) {
            return new JsonData(-1, "该号码已注册！");
        } else if (!userImpl.getEmailUnique(user.getEmail())) {
            return new JsonData(-1, "该邮箱已注册");
        } else {
            user.setCreate_time(new Date());
            user.setProfile_picture("http://112.124.44.175/image/logo.png");
            user.setBackground_image("http://112.124.44.175/backgroundPic/donut.jpg");

        }
        if (userImpl.add(user) == 1) {
            return new JsonData(0, "插入成功");
        } else
            return new JsonData(-1, "出错了");
    }

    @PostMapping("updateBackGround")
    public JsonData updateBackGround(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if ("success".equals(FileSaveUtil.getINSTANCE(userImpl, picImpl).saveFile(file, request, "backgroundImage"))) {
            return new JsonData(0, "success");
        } else
            return new JsonData(-1, "failure");
    }

    @PostMapping("updateProfilePic")
    public JsonData updateProfilePic(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if ("success".equals(FileSaveUtil.getINSTANCE(userImpl, picImpl).saveFile(file, request, "profileImage"))) {
            return new JsonData(0, "success");
        } else
            return new JsonData(-1, "failure");
    }

    @GetMapping(value = "getUserByKey", produces = "application/json;charset=UTF-8")
    public List<User> getUserByKey(String key) {
        return userImpl.findByUsername(key);
    }

    @GetMapping(value = "getUserById", produces = "application/json;charset=UTF-8")
    public User getUserById(int uid) {
        User foundUser = userImpl.findById(uid);
        foundUser.setPassword("");
        return foundUser;
    }

    @PostMapping("updateInfo")
    public JsonData updateInfo(@RequestBody User user) {
        System.out.println("telephone" + user.getTelephone());
        System.out.println("username" + user.getUsername());
        System.out.println("email" + user.getEmail());
        System.out.println("birthday" + user.getBirthday());
        if (userImpl.update(user) != 0) {
            return new JsonData(0, "SUCCESS");
        }
        return new JsonData(-1, "falure");
    }
@GetMapping("editPassword")
    public JsonData editPassword(String password,String uid){
        if (userImpl.updatePassword(password,Integer.parseInt(uid))!=0){
        return new JsonData(0,"SUCCESS");
}
    return new JsonData(-1,"failure");}

}