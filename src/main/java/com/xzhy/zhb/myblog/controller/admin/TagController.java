package com.xzhy.zhb.myblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzhy.zhb.myblog.pojo.Tag;
import com.xzhy.zhb.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

/**
 * @ClassNameTagController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/25 15:29
 * @Version V1.0
 **/
@Controller
@RequestMapping(value = "/admin")
public class TagController
{
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String getTagList(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<Tag> allTags = tagService.getAdminTag();
        System.out.println(allTags.toString());
        PageInfo<Tag> pageInfo  = new PageInfo<>(allTags);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/tags";
    }

    @GetMapping("tags/input")
    public String toAddPage(){
        return "admin/tags-input";
    }

    @PostMapping("/tags/add")
    public String add(Tag tag, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1!=null){
            attributes.addFlashAttribute("message","已有该标签，不能重复添加");
            return "redirect:admin/tags/input";
        }
        tagService.saveTag(tag);
        return "redirect:/admin/tags";
    }

    @GetMapping("tags/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("tag",tagService.getTagById(id));
        return "admin/tags-update";
    }

    @PostMapping("tags/update")
    public String editPost(Tag tag,RedirectAttributes attributes){
        tagService.updateTag(tag);
        attributes.addFlashAttribute("message","更新成功");
        return "redirect:/admin/tags";
    }

    @GetMapping("tags/{id}/delete")
    public String delete(@PathVariable Long id){
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
