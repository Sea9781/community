package com.ysu.forum.community.controller;

import com.ysu.forum.community.mapper.QuestionMapper;
import com.ysu.forum.community.mapper.UserMapper;
import com.ysu.forum.community.model.Question;
import com.ysu.forum.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-03 22:21
 **/
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title==null||title=="") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description==null||description=="") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag==null||tag=="") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User user = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.finbyToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionMapper.create(question);

        return "redirect:/";
    }
}
