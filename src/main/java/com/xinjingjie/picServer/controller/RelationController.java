package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.*;
import com.xinjingjie.picServer.impl.RelationImpl;
import com.xinjingjie.picServer.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/relation/")
public class RelationController {
    @Autowired
    private RelationImpl relationImpl;
@Autowired
private UserImpl userImpl;
    @GetMapping(value = "add", produces = "application/json;charset=UTF-8")
    public JsonData addRelation(int follower_id, int beFollower_id, String state) {
        Relation relation = new Relation(follower_id, beFollower_id, state, new Date());
        System.out.println(relation);
        if (relationImpl.addFollow(relation) != 0&&userImpl.setFans_numberAdd(beFollower_id)!= 0&& userImpl.setSub_numberAdd(follower_id)!= 0) {
            return new JsonData(0, "success");
        }
        return new JsonData(-1, "failure");
    }

    @GetMapping(value = "delete", produces = "application/json;charset=UTF-8")
    public JsonData deleteRelation(int follow_id, int beFollowed_id) {
        if (relationImpl.deleteFollow(follow_id, beFollowed_id) != 0) {
            return new JsonData(0, "success");
        }
        return new JsonData(-1, "failure");
    }

    @GetMapping(value = "findAllFollowUser", produces = "application/json;charset=UTF-8")
    public List<User> findAllFollowUser(int uid) {
        return relationImpl.allFollowedInfo(uid);
    }

    @GetMapping(value = "findAllBeFollowUser", produces = "application/json;charset=UTF-8")
    public List<User> findAllBeFollowUser(int uid) {
        return relationImpl.allBeFollowedInfo(uid);
    }

    @GetMapping(value = "findAllFollowPic", produces = "application/json;charset=UTF-8")
    public TotalPics findAllFollowPic(int uid) {
        return new TotalPics(100,20,relationImpl.allFollowedPicture(uid));
    }

    @GetMapping(value = "findAlFollowId",produces = "application/json;charset=UTF-8")
    public List<Integer> findAlFollowId(int uid){
        return relationImpl.allFollowed(uid);
    }
}
