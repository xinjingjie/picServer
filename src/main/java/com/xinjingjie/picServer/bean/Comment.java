package com.xinjingjie.picServer.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private int c_id;
    private int p_id;
    private int uid;
    private int likes;
    private int dislikes;
    private Date create_time;
    private String content;
    private String profile_picture;
    private String username;
    public Comment(int p_id, int uid, int likes, int dislikes, Date create_time, String content, String profile_picture, String username) {
        this.p_id = p_id;
        this.uid = uid;
        this.likes = likes;
        this.dislikes = dislikes;
        this.create_time = create_time;
        this.content = content;
        this.profile_picture = profile_picture;
        this.username = username;
    }

    public Comment() {
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "c_id=" + c_id +
                ", p_id=" + p_id +
                ", uid=" + uid +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", create_time=" + create_time +
                ", content='" + content + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
