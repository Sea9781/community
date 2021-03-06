package com.ysu.forum.community.dto;

import com.ysu.forum.community.model.User;
import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-05 21:37
 **/
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;
    private User user;
}

