package com.xzhy.zhb.myblog.mapper;

import com.xzhy.zhb.myblog.dto.*;
import com.xzhy.zhb.myblog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassNameBlogMapper
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/29 15:59
 * @Version V1.0
 **/
@Mapper
@Repository
public interface BlogMapper
{
    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog Blog);
    int deleteBlog(Long id);
    int updateBlog(ShowBlog showBlog);
    int saveBlogAndTag(BlogAndTag blogAndTag);
    int deleteBlogAndTag(Long blogId);
    List<BlogQuery> searchByConditions(Map<String,Object> searchParams);

    //前端展示
    List<FirstPageBlog> getFirstPageBlog();
    List<FirstPageBlog> getFirstPageBlogBySearch(String query);
    List<RecommendBlog> getRecommendBlog();
    List<FirstPageBlog> getFirstPageBlogByTypeId(Long typeId);
    List<FirstPageBlog> getFirstPageBlogByTagId(Long tagId);

    DetailedBlog getDetailedBlog(Long id);
}
