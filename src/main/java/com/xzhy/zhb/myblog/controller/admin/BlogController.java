package com.xzhy.zhb.myblog.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzhy.zhb.myblog.dto.BlogQuery;
import com.xzhy.zhb.myblog.dto.ShowBlog;
import com.xzhy.zhb.myblog.pojo.Blog;
import com.xzhy.zhb.myblog.pojo.User;
import com.xzhy.zhb.myblog.service.BlogService;
import com.xzhy.zhb.myblog.service.TagService;
import com.xzhy.zhb.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    public void setTypeAndTag(Model model){
        model.addAttribute("types",typeService.getAdminType());
        model.addAttribute("tags",tagService.getAdminTag());
    }

    @GetMapping("/blogs")
    public String blogs(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<BlogQuery> blogQueryList = blogService.queryAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueryList);
        model.addAttribute("pageInfo",pageInfo);
        setTypeAndTag(model);
        return "admin/blogs";
    }

    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes){
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/input")
    public String toAddBlog(Model model){
        setTypeAndTag(model);
        return "/admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String addBlog(Blog blog, RedirectAttributes attributes, HttpSession httpSession){
        blog.setUser((User) httpSession.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //给blog中的List<Tag>赋值
        blog.setTags(tagService.getTagByString(blog.getTagIds()));
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        blogService.saveBlog(blog);
        attributes.addFlashAttribute("message", "新增成功");
        return "redirect:/admin/blogs";
    }


    @PostMapping("/blogs/search")
    public String searchBlog(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum, HttpServletRequest request){
        Map searchParams = new HashMap();
        String typeId = request.getParameter("typeId");
        String title = request.getParameter("title");
        String recommend = request.getParameter("recommend");
        if (StringUtils.isEmpty(title)){
            searchParams.put("title",title);
        }
        if (StringUtils.isEmpty(typeId)){
            searchParams.put("typeId",typeId);
        }
        if (StringUtils.isEmpty(recommend)){
            searchParams.put("recommend",1);
        }

        List<BlogQuery> blogQueryList = blogService.getBlogBySearch(searchParams);
        PageHelper.startPage(pageNum,3);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueryList);
        model.addAttribute("pageInfo",pageInfo);
        setTypeAndTag(model);
        model.addAttribute("message","查询成功");
        return "admin/blogs";
    }

    @GetMapping("/blogs/{id}/input")
    public String toUpdate(@PathVariable Long id, Model model){
        ShowBlog showBlog = blogService.queryBlogById(id);
        setTypeAndTag(model);
        model.addAttribute("blog",showBlog);
        return "admin/blogs-update";
    }

    @PostMapping("/blogs/update")
    public String editPost(ShowBlog showBlog,RedirectAttributes attributes) {
        blogService.updateBlog(showBlog);
        attributes.addFlashAttribute("message", "修改成功");
        return "redirect:/admin/blogs";
    }
}