package com.xzhy.zhb.myblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.xzhy.zhb.myblog.mapper.TagMapper;
import com.xzhy.zhb.myblog.pojo.Tag;
import com.xzhy.zhb.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameTagServiceImpl
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/25 14:32
 * @Version V1.0
 **/
@Service
public class TagServiceImpl implements TagService
{

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag)
    {
        return tagMapper.saveTag(tag);
    }

    @Override
    public int updateTag(Tag tag)
    {
        return tagMapper.updateTag(tag);
    }

    @Override
    public int deleteTag(Long id)
    {
        return tagMapper.deleteTag(id);
    }

    @Override
    public Tag getTagById(Long id)
    {
        return tagMapper.getTagById(id);

    }

    @Override
    public Tag getTagByName(String name)
    {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> getAllTag()
    {
        List<Tag> tags = tagMapper.getAllTag();
        return tags;
    }

    @Override
    public List<Tag> getTagByString(String text)
    {
        List<Tag> tags = new ArrayList<>();
        List<Long> ids = convertToList(text);
        for (Long id : ids){
            tags.add(tagMapper.getTagById(id));
        }
        return tags;
    }


    @Override
    public List<Tag> getAdminTag()

    {
        List<Tag> tags = tagMapper.getAdminTag();
        // System.out.println("+++++++++++++++++++"+JSON.toJSONString(tags));
        return tags;
    }

    //分割输入得字符串
    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids)&& ids!=null){
            String[] idArray = ids.split(",");
            for (String id : idArray){
                list.add(new Long(id));
            }
        }
        return list;
    }
}
