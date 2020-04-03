package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.Picture;
import com.xinjingjie.picServer.bean.Relation;
import com.xinjingjie.picServer.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RelationMapper {
    @Insert("INSERT INTO relation(follower_id,beFollowed_id,state,follow_time) VALUES(#{follower_id},#{beFollowed_id},#{state},#{follow_time})")
    int addFollow(Relation relation);
    @Delete("DELETE FROM relation WHERE follower_id=#{follower_id} AND beFollowed_id=#{beFollowed_id}")
    int deleteFollow(int follower_id,int beFollowed_id);
    /*
    查询本人所有关注的人的id
     */
    @Select("SELECT beFollowed_id FROM relation WHERE follower_id=#{follower_id}")
    List<Integer> allFollowed(int follower_id);
    /*
    查询关注本人的人的id
     */
    @Select("SELECT follower_id FROM relation WHERE beFollowed_id=#{beFollowed_id}")
    List<Integer> allBeFollowed(int beFollowed_id);
    /*
      查询本人所有关注的人的所有信息
       */
    @Select("select * from user where uid IN(select DISTINCT beFollowed_id from relation where follower_id=#{uid})")
    List<User> allFollowedInfo(int uid);
    /*
        查询关注本人的人的所有信息
         */
    @Select("select * from user where uid IN(select DISTINCT follower_id from relation where beFollowed_id=#{uid})")
    List<User> allBeFollowedInfo(int uid);

    /*
    查询关注人发布的图片
     */
    @Select("select * from picture where user_id IN(select DISTINCT beFollowed_id from relation where follower_id=#{uid}) order by update_time desc")
    List<Picture> allFollowedPicture(int uid);
}
