package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.Picture;
import com.xinjingjie.picServer.mapper.PicMapper;
import com.xinjingjie.picServer.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PicImpl implements PicService {
    @Autowired
    PicMapper picMapper;
    @Override
    public int add(Picture picture) {
        return picMapper.add(picture);
    }

    @Override
    public List<Picture> getAllByUserId(int user_id) {
        return picMapper.getAllByUserId(user_id);
    }

    @Override
    public int getCountById(int user_id) {
        return picMapper.getCountById(user_id);
    }

    @Override
    public int getCountByContent(String content) {
        return picMapper.getCountByContent("%"+content+"%");
    }

    @Override
    public List<Picture> getPicsByContent(String content) {
        return picMapper.getPicsByContent("%"+content+"%");
    }

    @Override
    public int getCountByTag(String tag) {
        return picMapper.getCountByTag("%"+tag+"%");
    }

    @Override
    public List<Picture> getPicsByTag(String tag) {
        return picMapper.getPicsByTag("%"+tag+"%");
    }

    @Override
    public List<Picture> getPicsByLikes() {
        return picMapper.getPicsByLikes();
    }

    @Override
    public List<Picture> getPicsByComments() {
        return picMapper.getPicsByComments();
    }

    @Override
    public int updateLikeNum(int num, int p_id) {
        return picMapper.updateLikeNum(num, p_id);
    }

    @Override
    public int updateCommentsNum(int num, int p_id) {
        return picMapper.updateCommentsNum(num, p_id);
    }
}
