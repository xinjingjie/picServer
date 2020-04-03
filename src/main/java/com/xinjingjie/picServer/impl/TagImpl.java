package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.Tag;
import com.xinjingjie.picServer.mapper.TagMapper;
import com.xinjingjie.picServer.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Override
    public void insert(Tag tag) {
        tagMapper.insert(tag);
    }

    @Override
    public boolean isExist(String name) {
        return tagMapper.findByName(name)==0;
    }

    @Override
    public List<Tag> allTagByName(String name) {
        return tagMapper.allTagByName("%"+name+"%");
    }
}
