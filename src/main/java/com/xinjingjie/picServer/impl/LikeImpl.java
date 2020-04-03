package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.Like;
import com.xinjingjie.picServer.mapper.LikeMapper;
import com.xinjingjie.picServer.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;
    @Override
    public int insert(Like like) {
        return likeMapper.insert(like);
    }

    @Override
    public int delete(int l_id) {
        return likeMapper.delete(l_id);
    }
}
