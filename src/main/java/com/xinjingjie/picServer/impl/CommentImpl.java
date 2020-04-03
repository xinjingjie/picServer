package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.Comment;
import com.xinjingjie.picServer.mapper.CommentMapper;
import com.xinjingjie.picServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteComment(int c_id) {
        return commentMapper.deleteComment(c_id);
    }

    @Override
    public int updateLikeNum(int num, int c_id) {
        return commentMapper.updateLikeNum(num, c_id);
    }

    @Override
    public int updateDisLikeNum(int num, int c_id) {
        return commentMapper.updateDisLikeNum(num, c_id);
    }

    @Override
    public List<Comment> findAllByPid(int p_id) {
        return commentMapper.findAllByPid(p_id);
    }
}
