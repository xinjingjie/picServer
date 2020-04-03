package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface LikeMapper {
    @Insert("INSERT INTO `like`(p_id,like_uid) VALUES (#{p_id},#{like_uid})")
    int insert(Like like);
    @Delete("DELETE FROM like WHERE l_id=#{l_id}")
    int delete(int l_id);
}
