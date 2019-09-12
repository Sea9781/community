package com.ysu.forum.community.dto;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-02 10:44
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
