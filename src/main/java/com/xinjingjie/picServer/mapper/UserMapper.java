package com.xinjingjie.picServer.mapper;

import com.xinjingjie.picServer.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO user(username,gender,password,age,create_time,telephone,email,pic_number,fans_number,sub_number,profile_picture,background_image) VALUES(#{username}, #{gender}, #{password}, #{age}, #{create_time}, #{telephone}, #{email}, #{pic_number},#{fans_number},#{sub_number},#{profile_picture},#{background_image})")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
        //keyProperty java对象的属性；keyColumn表示数据库的字段
    int insert(User user);

    /*
    获取全部user
     */
    @Select("SELECT * FROM user")
    List<User> getAll();
    /*
    判断用户是否存在
     */
    @Select("SELECT count(*) FROM user WHERE uid = #{uid}")
    int isExist(int uid);
    /*
    判断手机号是否唯一
     */
    @Select("SELECT count(*) FROM user WHERE telephone = #{telephone}")
    int findPhone(String telephone);
    /*
    判断邮箱是否唯一
     */
    @Select("SELECT count(*) FROM user WHERE email = #{email}")
    int findEmail(String email);
    /*
    根据id查找user
     */
    @Select("SELECT * FROM user WHERE uid = #{uid}")
    @Results({
            @Result(column = "create_time",property = "create_time")
    })
    User findById(int uid);
    /*
    查找所有名字为username的用户
     */
    @Select("SELECT * FROM user WHERE username like #{username}")
    List<User> findByName(String username);
    /*
    根据telephone查找用户
     */
    @Select("SELECT * FROM user WHERE telephone = #{telephone}")
    @Results({
            @Result(column = "create_time",property = "create_time")
    })
    User findByPhone(String telephone);

    /*
根据email查找用户
 */
    @Select("SELECT * FROM user WHERE email = #{email}")
    @Results({
            @Result(column = "create_time",property = "create_time")
    })
    User findByEmail(String email);
    /*
    更新username
     */
    @Update("UPDATE user SET username=#{username},gender=#{gender},email=#{email},telephone=#{telephone},age=#{age},birthday=#{birthday} WHERE uid =#{uid}")
    int update(User user);
    /*
    删除用户
     */
    @Delete("DELETE FROM user WHERE uid =#{userId}")
    int delete(int userId);
/*
根据id查找username
 */
    @Select("SELECT username FROM user WHERE uid=#{uid}")
    String findUsernameById(int uid);
  /*
  图片数量+1
   */
    @Update("UPDATE user set pic_number=pic_number+1 WHERE uid=#{uid}")
    int setPic_numberAdd(int uid);
    /*
  关注数量+1
   */
    @Update("UPDATE user set sub_number=sub_number+1 WHERE uid=#{uid}")
    int setSub_numberAdd(int uid);
    /*
  粉丝数量+1
   */
    @Update("UPDATE user set fans_number=fans_number+1 WHERE uid=#{uid}")
    int setFans_numberAdd(int uid);
    /*
    修改头像
     */
    @Update("UPDATE user SET profile_picture=#{profile_picture} WHERE uid=#{uid}")
    int updateProfilePic(int uid,String profile_picture);
    /*
    修改背景
     */
    @Update("UPDATE user SET background_image=#{background_image} WHERE uid=#{uid}")
    int updateBackGroundPic(int uid,String background_image);
/*
查找头像
 */
    @Select("SELECT profile_picture FROM user WHERE uid=#{uid}")
    String findProfilePic(int uid);

    /*
    修改密码
     */
    @Update("UPDATE user SET password=#{password} WHERE uid=#{uid}")
    int updatePassword(String password,int uid);
}
