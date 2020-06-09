package com.xzhy.zhb.myblog.mapper;

import com.xzhy.zhb.myblog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNameTagMapper
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/25 10:56
 * @Version V1.0
 **/
@Mapper
@Repository
public interface TagMapper
{
    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTag(Long id);

    Tag getTagById(Long id);

    Tag getTagByName(String name);


    List<Tag> getAllTag();

    List<Tag> getAdminTag();
}
