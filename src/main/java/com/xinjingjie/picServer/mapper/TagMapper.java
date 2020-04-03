package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {
    @Insert("Insert into tag values(#{t_id},#{tagName})")
    void insert(Tag tag);

    @Select("Select count(*) from tag where tagName=#{name}")
    int findByName(String name);

    @Select("Select * from tag where tagName like #{name}")
    List<Tag> allTagByName(String name);
}
