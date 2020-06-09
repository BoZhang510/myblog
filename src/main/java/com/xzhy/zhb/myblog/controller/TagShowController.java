package com.xzhy.zhb.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzhy.zhb.myblog.dto.FirstPageBlog;
import com.xzhy.zhb.myblog.pojo.Blog;
import com.xzhy.zhb.myblog.pojo.Tag;
import com.xzhy.zhb.myblog.service.BlogService;
import com.xzhy.zhb.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassNameTagShowController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/8
 * 9:23
 * @Version V1.0
 **/
@Controller
public class TagShowController
{
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    @GetMapping("tags/{id}")
    public String blogListTagId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @PathVariable Long id, Model model){
        List<Tag> tags = tagService.getAllTag();
        if (id == -1){
            id = tags.get(0).getId();
        }
        List<FirstPageBlog> firstPageBlogs = blogService.getBlogByTag(id);
        PageHelper.startPage(pageNum,100);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        model.addAttribute("tags",tags);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
