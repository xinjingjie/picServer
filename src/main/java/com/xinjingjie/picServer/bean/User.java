package com.xinjingjie.picServer.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private int uid;
    private String username;
    private String gender;
    private String password;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date create_time;
    private String telephone;
    private String email;
    private Integer pic_number;
    private int fans_number;
    private int sub_number;
    private String profile_picture;
    private String background_image;
private String birthday;
    public User(String username, String gender, String password, int age, Date create_time, String telephone, String email, Integer pic_number, int fans_number, int sub_number, String profile_picture, String background_image, String birthday) {
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.age = age;
        this.create_time = create_time;
        this.telephone = telephone;
        this.email = email;
        this.pic_number = pic_number;
        this.fans_number = fans_number;
        this.sub_number = sub_number;
        this.profile_picture = profile_picture;
        this.background_image = background_image;
        this.birthday = birthday;
    }

    public User() {
    }

    public User(int uid, String username, String gender, String password, int age, Date create_time, String telephone, String email, Integer pic_number, int fans_number, int sub_number, String profile_picture, String background_image, String birthday, String birthday1) {
        this.uid = uid;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.age = age;
        this.create_time = create_time;
        this.telephone = telephone;
        this.email = email;
        this.pic_number = pic_number;
        this.fans_number = fans_number;
        this.sub_number = sub_number;
        this.profile_picture = profile_picture;
        this.background_image = background_image;
        this.birthday = birthday1;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", create_time=" + create_time +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", pic_number=" + pic_number +
                ", fans_number=" + fans_number +
                ", sub_number=" + sub_number +
                '}';
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public int getFans_number() {
        return fans_number;
    }

    public void setFans_number(int fans_number) {
        this.fans_number = fans_number;
    }

    public int getSub_number() {
        return sub_number;
    }

    public void setSub_number(int sub_number) {
        this.sub_number = sub_number;
    }

    public Integer getPic_number() {
        return pic_number;
    }

    public void setPic_number(Integer pic_number) {
        this.pic_number = pic_number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
