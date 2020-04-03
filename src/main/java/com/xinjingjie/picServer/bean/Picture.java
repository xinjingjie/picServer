package com.xinjingjie.picServer.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
    private static final long serialVersionUID = 1L;

    private int p_id;
    private int user_id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date update_time;
    private String location;
    private int likes;
    private int comments;
    private String content;
    private String tags;
    private String profile_picture;

    public Picture() {
    }

    public Picture(int user_id, String username, Date update_time, String location, int likes, int comments, String content, String tags, String profile_picture) {
        this.user_id = user_id;
        this.profile_picture = profile_picture;
        this.username = username;
        this.update_time = update_time;
        this.location = location;
        this.likes = likes;
        this.comments = comments;
        this.content = content;
        this.tags = tags;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getP_id() {
        return p_id;
    }

    public String getLocation() {
        return location;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "p_id=" + p_id +
                ", username=" + username +
                ", updateTime=" + update_time +
                ", location='" + location + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }


}
