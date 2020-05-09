package com.xzhy.zhb.myblog.controller;

import com.xzhy.zhb.myblog.NotFoundException;
import com.xzhy.zhb.myblog.aspect.WebLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassNameIndexController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/22 17:15
 * @Version V1.0
 **/
@Controller
public class IndexController
{
    @RequestMapping("index")
    @WebLog(blogDesc = "主页")
    public String index(){
        // int i = 9/0;
        // String blog = null;
        // if (blog == null){
        //     throw new NotFoundException("博客不存在");
        // }
        System.out.println("hello");
        return "index";
    }
}
