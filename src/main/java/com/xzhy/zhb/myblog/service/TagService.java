package com.xzhy.zhb.myblog.service;

import com.xzhy.zhb.myblog.pojo.Tag;

import java.util.List;

/**
 * @ClassNameTagService
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/14 15:53
 * @Version V1.0
 **/
public interface TagService
{
    //基于该对象得curd
    int saveTag(Tag tag);
    int updateTag(Tag tag);
    int deleteTag(Long id);

    Tag getTagById(Long id);
    Tag getTagByName(String name);

    //业务需求
    List<Tag> getAllTag();
    List<Tag> getTagByString(String text);
    List<Tag> getAdminTag();


}
