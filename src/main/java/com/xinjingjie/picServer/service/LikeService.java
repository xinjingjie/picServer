package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.Like;
import org.springframework.stereotype.Service;


public interface LikeService {
    int insert(Like like);
    int delete(int l_id);
}
