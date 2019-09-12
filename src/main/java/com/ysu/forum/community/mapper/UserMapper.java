package com.ysu.forum.community.mapper;

import com.ysu.forum.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-03 10:07
 **/
@Component
public interface UserMapper {
    @Insert("insert into `user` (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User finbyToken(String token);

    @Select("select * from user where id=#{creator}")
    User findById(Integer creator);
}
