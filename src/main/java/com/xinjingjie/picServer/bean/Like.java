package com.xinjingjie.picServer.bean;

import java.io.Serializable;
/*
图片点赞表
 */
public class Like implements Serializable {
    private static final long serialVersionUID = 1L;
    private int l_id;
    private int p_id;
    private int like_uid;

    public Like(int p_id, int like_uid) {
        this.p_id = p_id;
        this.like_uid = like_uid;
    }

    public Like() {
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getLike_uid() {
        return like_uid;
    }

    public void setLike_uid(int like_uid) {
        this.like_uid = like_uid;
    }

    @Override
    public String toString() {
        return "Like{" +
                "l_id=" + l_id +
                ", p_id=" + p_id +
                ", belike_uid=" + like_uid +
                '}';
    }
}
