package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PicMapper {
/*
添加图片
 */
    @Insert("INSERT INTO picture(user_id,username,update_time,location,likes,comments,content,tags,profile_picture) VALUES (#{user_id},#{username},#{update_time},#{location},#{likes},#{comments},#{content},#{tags},#{profile_picture})")
    int add(Picture picture);
/*
根据id获取所有图片
 */
    @Select("SELECT * FROM picture where user_id=#{user_id}")
    List<Picture> getAllByUserId(int user_id);
/*
查找uid的图片数量
 */
    @Select("SELECT COUNT(*) FROM picture WHERE user_id=#{user_id}")
    int getCountById(int user_id);
/*
内容为content的图片数量
 */
    @Select("SELECT count(*) FROM picture WHERE content LIKE #{content}")
    int getCountByContent(String content);
/*
根据内容查找图片
 */
    @Select("SELECT * FROM picture WHERE content LIKE #{content} or tags LIKE #{content}")
    List<Picture> getPicsByContent(String content);
/*
查找tag为tag的图片数量

 */
    @Select("SELECT count(*) FROM picture WHERE tags LIKE #{tag}")
    int getCountByTag(String tag);
/*
根据tag查找图片
 */
    @Select("SELECT * FROM picture WHERE tags LIKE #{tag}")
    List<Picture> getPicsByTag(String tag);
/*
获取点赞数最高的20个
 */
    @Select("SELECT * FROM picture ORDER BY likes ASC LIMIT 0,20")
    List<Picture> getPicsByLikes();
/*
获取评论最多的20个
 */
    @Select("SELECT * FROM picture ORDER BY comments ASC LIMIT 0,20")
    List<Picture> getPicsByComments();
    /*
    根据pid点赞或者取消赞
     */
    @Update("UPDATE picture SET likes=likes+#{num} WHERE p_id=#{p_id}")
    int updateLikeNum(int num,int p_id);
    /*
    评论数+1或-1
     */
    @Update("UPDATE picture SET comments=comments+#{num} WHERE p_id=#{p_id}")
    int updateCommentsNum(int num,int p_id);
}
