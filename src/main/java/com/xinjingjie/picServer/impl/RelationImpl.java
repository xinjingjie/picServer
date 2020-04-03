package com.xinjingjie.picServer.impl;

import com.xinjingjie.picServer.bean.Picture;
import com.xinjingjie.picServer.bean.Relation;
import com.xinjingjie.picServer.bean.User;
import com.xinjingjie.picServer.mapper.RelationMapper;
import com.xinjingjie.picServer.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationImpl implements RelationService {
    @Autowired
    private RelationMapper relationMapper;
    @Override
    public int addFollow(Relation relation) {
        return relationMapper.addFollow(relation);
    }

    @Override
    public int deleteFollow(int follower_id, int beFollowed_id) {
        return relationMapper.deleteFollow(follower_id,beFollowed_id);
    }


    @Override
    public List<Integer> allFollowed(int follower_id) {
        return relationMapper.allFollowed(follower_id);
    }

    @Override
    public List<Integer> allBeFollowed(int beFollowed_id) {
        return relationMapper.allBeFollowed(beFollowed_id);
    }

    @Override
    public List<User> allFollowedInfo(int uid) {
        return relationMapper.allFollowedInfo(uid);
    }

    @Override
    public List<User> allBeFollowedInfo(int uid) {
        return relationMapper.allBeFollowedInfo(uid);
    }

    @Override
    public List<Picture> allFollowedPicture(int uid) {
        return relationMapper.allFollowedPicture(uid);
    }
}
