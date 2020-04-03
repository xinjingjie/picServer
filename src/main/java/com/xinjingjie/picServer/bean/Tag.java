package com.xinjingjie.picServer.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    private int t_id;
    private String tagName;

    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "t_id=" + t_id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
