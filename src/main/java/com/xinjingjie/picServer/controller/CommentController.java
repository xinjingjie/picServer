package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.Comment;
import com.xinjingjie.picServer.bean.JsonData;
import com.xinjingjie.picServer.impl.CommentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comment/")
public class CommentController {
    @Autowired
    private CommentImpl commentImpl;

    @GetMapping(value = "getAllByPid",produces="application/json;charset=UTF-8")
    public List<Comment> getAllByPid(int pid) {
        List<Comment> allComments = commentImpl.findAllByPid(pid);
        return allComments;
    }
}
