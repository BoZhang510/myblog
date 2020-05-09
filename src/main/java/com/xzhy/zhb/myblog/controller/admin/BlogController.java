package com.xzhy.zhb.myblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassNameBlogController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/6 15:53
 * @Version V1.0
 **/
@Controller
@RequestMapping("/admin")
public class BlogController
{

    @GetMapping("/blogs")
    public String blogs(){
        return "admin/blogs";
    }
}
