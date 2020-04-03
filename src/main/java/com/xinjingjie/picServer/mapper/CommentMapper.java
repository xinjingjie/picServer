package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {
    @Insert("INSERT INTO comment(p_id,uid,likes,dislikes,create_time,content,profile_picture,username) VALUES (#{p_id},#{uid},#{likes},#{dislikes},#{create_time},#{content},#{profile_picture},#{username})")
    int addComment(Comment comment);

    @Delete("DELETE FROM commnet WHERE c_id=#{c_id}")
    int deleteComment(int c_id);
/*
    根据cid点赞或者取消赞
     */
    @Update("UPDATE commnet SET likes=likes+#{num} WHERE c_id=#{c_id}")
    int updateLikeNum(int num,int c_id);
    /*
    根据cid增加或者取消dislike
     */
    @Update("UPDATE commnet SET dislikes=dislikes+#{num} WHERE c_id=#{c_id}")
    int updateDisLikeNum(int num,int c_id);
    /*
    查询pid的所有评论,按照点赞数排列
     */
    @Select("SELECT * FROM comment WHERE p_id=#{p_id} ORDER BY likes DESC")
    List<Comment> findAllByPid(int p_id);
}
