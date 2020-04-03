package com.xinjingjie.picServer.service;

import com.xinjingjie.picServer.bean.Picture;

import java.util.List;

public interface PicService {
    int add(Picture picture);

    List<Picture> getAllByUserId(int user_id);

    int getCountById(int user_id);

    int getCountByContent(String content);

    List<Picture> getPicsByContent(String content);

    int getCountByTag(String tag);

    List<Picture> getPicsByTag(String tag);

    List<Picture> getPicsByLikes();

    List<Picture> getPicsByComments();

    int updateLikeNum(int num, int p_id);

    int updateCommentsNum(int num, int p_id);
}
