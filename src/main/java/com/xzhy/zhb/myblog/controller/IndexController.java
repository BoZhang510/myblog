package com.xzhy.zhb.myblog.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzhy.zhb.myblog.NotFoundException;
import com.xzhy.zhb.myblog.aspect.WebLog;
import com.xzhy.zhb.myblog.dto.DetailedBlog;
import com.xzhy.zhb.myblog.dto.FirstPageBlog;
import com.xzhy.zhb.myblog.dto.RecommendBlog;
import com.xzhy.zhb.myblog.pojo.Comment;
import com.xzhy.zhb.myblog.pojo.Tag;
import com.xzhy.zhb.myblog.pojo.Type;
import com.xzhy.zhb.myblog.service.BlogService;
import com.xzhy.zhb.myblog.service.CommentService;
import com.xzhy.zhb.myblog.service.TagService;
import com.xzhy.zhb.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

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
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    @WebLog(blogDesc = "主页")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,6);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<Type> allType = typeService.getAllByType();
        List<Tag> allTag = tagService.getAllTag();
        List<RecommendBlog> recommendBlogs = blogService.getRecommendBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("tags",allTag);
        model.addAttribute("types",allType);
        model.addAttribute("recommendedBlogs",recommendBlogs);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam String query,Model model){
        PageHelper.startPage(pageNum,20);
        List<FirstPageBlog> firstPageBlogs = blogService.searchBlog(query);
        System.out.println(JSON.toJSONString(firstPageBlogs));
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model)
    {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.getCommentsById(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}
