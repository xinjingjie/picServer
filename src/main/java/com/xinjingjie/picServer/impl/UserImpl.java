package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.User;
import com.xinjingjie.picServer.mapper.UserMapper;
import com.xinjingjie.picServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int add(User user) {
        return  userMapper.insert(user);
    }

    public  boolean getPhoneUnique(String phoneNumber){
        return userMapper.findPhone(phoneNumber) == 0;
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByName("%"+username+"%");
    }

    @Override
    public boolean getEmailUnique(String email) {
        return userMapper.findEmail(email)==0;
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public int setPic_numberAdd(int uid) {
        return userMapper.setPic_numberAdd(uid);
    }

    @Override
    public int setFans_numberAdd(int uid) {
        return userMapper.setFans_numberAdd(uid);
    }

    @Override
    public int setSub_numberAdd(int uid) {
        return userMapper.setSub_numberAdd(uid);
    }

    @Override
    public String findUsernameById(int uid) {
        return userMapper.findUsernameById(uid);
    }

    @Override
    public int updateProfilePic(int uid, String profile_picture) {
        return userMapper.updateProfilePic(uid,profile_picture);
    }

    @Override
    public int updateBackGroundPic(int uid, String background_image) {
        return userMapper.updateBackGroundPic(uid, background_image);
    }

    @Override
    public String findProfilePic(int uid) {
        return userMapper.findProfilePic(uid);
    }

    @Override
    public int updatePassword(String password, int uid) {
        return userMapper.updatePassword(password,uid);
    }

    @Override
    public int delete(int uid) {
        return userMapper.delete(uid);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.getAll();
    }

    @Override
    public User findById(int uid) {
        return userMapper.findById(uid);
    }

    @Override
    public boolean isExist(int id) {
        return userMapper.isExist(id)!=0;
    }

}
