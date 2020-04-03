package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.Comment;

import java.util.List;

public interface CommentService {
    int addComment(Comment comment);

    int deleteComment(int c_id);

    int updateLikeNum(int num, int c_id);

    int updateDisLikeNum(int num, int c_id);

    List<Comment> findAllByPid(int p_id);

}
