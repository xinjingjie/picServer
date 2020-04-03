package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.User;

import java.util.List;

public interface UserService {
     int add(User user);
     int delete(int uid);
     int update(User user);
     List<User> findAll();
     User findById(int uid);
     boolean isExist(int id);
      boolean getPhoneUnique(String phone);
     List<User> findByUsername(String username);
     boolean getEmailUnique(String email);
     User findByPhone(String phone);
     User findByEmail(String email);
     int setPic_numberAdd(int uid);
     int setFans_numberAdd(int uid);
     int setSub_numberAdd(int uid);
     String findUsernameById(int uid);
     int updateProfilePic(int uid,String profile_picture);
     int updateBackGroundPic(int uid,String background_image);
     String findProfilePic(int uid);
     int updatePassword(String password,int uid);

}
