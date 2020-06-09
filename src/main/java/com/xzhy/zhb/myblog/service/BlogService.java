package com.xzhy.zhb.myblog.service;

import com.xzhy.zhb.myblog.dto.*;
import com.xzhy.zhb.myblog.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @ClassNameBlogService
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/29 15:17
 * @Version V1.0
 **/
public interface BlogService
{
    ShowBlog queryBlogById(Long id);
    List<BlogQuery> queryAllBlog();
    int saveBlog(Blog blog);
    int updateBlog(ShowBlog showBlog);
    int deleteBlog(Long id);
    List<BlogQuery> getBlogBySearch(Map<String,Object> searchParams);

    List<FirstPageBlog> getAllFirstPageBlog();
    List<RecommendBlog> getRecommendBlog();
    List<FirstPageBlog> searchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    List<FirstPageBlog> getBlogByType(Long id);
    List<FirstPageBlog> getBlogByTag(Long id);
}
