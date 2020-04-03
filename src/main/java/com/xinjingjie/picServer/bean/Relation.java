package com.xinjingjie.picServer.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Relation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int f_id;
    /*
    关注者
     */
    private int follower_id;
    /*
    被关注者
     */
    private int beFollowed_id;
    private String state;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date follow_time;

    public Relation() {
    }

    public Relation(int follower_id, int beFollowed_id, String state, Date follow_time) {
        this.follower_id = follower_id;
        this.beFollowed_id = beFollowed_id;
        this.state = state;
        this.follow_time = follow_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    public int getBeFollowed_id() {
        return beFollowed_id;
    }

    public void setBeFollowed_id(int beFollowed_id) {
        this.beFollowed_id = beFollowed_id;
    }

    public Date getFollow_time() {
        return follow_time;
    }

    public void setFollow_time(Date follow_time) {
        this.follow_time = follow_time;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "f_id=" + f_id +
                ", follower_id=" + follower_id +
                ", beFollowed_id=" + beFollowed_id +
                ", state='" + state + '\'' +
                ", follow_time=" + follow_time +
                '}';
    }
}
