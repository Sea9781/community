package com.ysu.forum.community.dto;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-02 11:19
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
