package com.xzhy.zhb.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassNameAboutShowController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/8 9:23
 * @Version V1.0
 **/
@Controller
public class AboutShowController
{
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
