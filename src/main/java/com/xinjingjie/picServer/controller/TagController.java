package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.Tag;
import com.xinjingjie.picServer.impl.TagImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/tag/")
public class TagController {


    @Autowired
    private TagImpl tagImpl;

    @GetMapping(value = "getByTag", produces = "application/json;charset=UTF-8")
    public List<Tag> getByTag(String key) {
        return tagImpl.allTagByName(key);
    }

}
