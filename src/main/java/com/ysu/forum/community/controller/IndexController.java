package com.ysu.forum.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-01 22:40
 **/
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
