package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.Tag;

import java.util.List;

public interface TagService {
    void insert(Tag tag);
    boolean isExist(String name);
    List<Tag> allTagByName(String name);

}
