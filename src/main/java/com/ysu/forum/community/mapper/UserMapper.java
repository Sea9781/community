package com.ysu.forum.community.mapper;

import com.ysu.forum.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-03 10:07
 **/
@Component
public interface UserMapper {
    @Insert("insert into `user` (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
