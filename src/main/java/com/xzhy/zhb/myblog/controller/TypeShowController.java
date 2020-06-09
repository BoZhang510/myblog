package com.xzhy.zhb.myblog.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzhy.zhb.myblog.dto.FirstPageBlog;
import com.xzhy.zhb.myblog.pojo.Type;
import com.xzhy.zhb.myblog.service.BlogService;
import com.xzhy.zhb.myblog.service.TypeService;
import net.sf.jsqlparser.statement.select.First;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

/**
 * @ClassNameTypeShowController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/8 9:22
 * @Version V1.0
 **/
@Controller
public class TypeShowController
{
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String BlogListTypeId(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @PathVariable Long id, Model model){
        List<Type> types = typeService.getAllByType();

        //-1 表示从首页导航点进来
        if (id==-1){
            id=types.get(0).getId();
        }

        model.addAttribute("types",types);
        List<FirstPageBlog> blogs = blogService.getBlogByType(id);
        System.out.println(JSON.toJSONString(blogs));
        PageHelper.startPage(pageNum,100);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
