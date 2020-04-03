package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.Picture;
import com.xinjingjie.picServer.bean.Relation;
import com.xinjingjie.picServer.bean.User;

import java.util.List;

public interface RelationService {
    int addFollow(Relation relation);
    int deleteFollow(int follower_id,int beFollowed_id);
    List<Integer> allFollowed(int follower_id);
    List<Integer> allBeFollowed(int beFollowed_id);
    List<User> allFollowedInfo(int uid);
    List<User> allBeFollowedInfo(int uid);
    List<Picture> allFollowedPicture(int uid);

}
