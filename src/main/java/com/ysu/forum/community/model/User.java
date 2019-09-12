package com.ysu.forum.community.model;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-03 10:08
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String avatar_url;
}
