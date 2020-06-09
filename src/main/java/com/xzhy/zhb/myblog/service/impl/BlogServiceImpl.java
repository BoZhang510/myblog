package com.xzhy.zhb.myblog.service.impl;

import com.xzhy.zhb.myblog.NotFoundException;
import com.xzhy.zhb.myblog.dto.*;
import com.xzhy.zhb.myblog.mapper.BlogMapper;
import com.xzhy.zhb.myblog.pojo.Blog;
import com.xzhy.zhb.myblog.pojo.Tag;
import com.xzhy.zhb.myblog.service.BlogService;
import com.xzhy.zhb.myblog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassNameBlogServiceImpl
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/29 15:51
 * @Version V1.0
 **/
@Service
public class BlogServiceImpl implements BlogService
{
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public ShowBlog queryBlogById(Long id)
    {
        return blogMapper.getBlogById(id);
    }

    @Override
    public List<BlogQuery> queryAllBlog()
    {
        List<BlogQuery> blogQueryList = blogMapper.getAllBlogQuery();
        return blogQueryList;
    }

    @Override
    public int saveBlog(Blog blog)

    {
        Date currentTime = new Date();
        int viewNum = 0;
        blog.setCreateTime(currentTime);
        blog.setUpdateTime(currentTime);
        blog.setViews(viewNum);

        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag:tags) {
            blogAndTag  = new BlogAndTag(tag.getId(),blog.getId());
            blogMapper.saveBlogAndTag(blogAndTag);
        }
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog)
    {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    @Override
    public int deleteBlog(Long id)
    {
        blogMapper.deleteBlog(id);
        blogMapper.deleteBlogAndTag(id);
        return 1;
    }

    @Override
    public List<BlogQuery> getBlogBySearch(Map<String,Object> searchParams)
    {
        return blogMapper.searchByConditions(searchParams);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog()
    {
        return blogMapper.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendBlog()
    {
        return blogMapper.getRecommendBlog();
    }

    @Override
    public List<FirstPageBlog> searchBlog(String query)
    {
        return blogMapper.getFirstPageBlogBySearch(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id)
    {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlog(id);
        if (detailedBlog == null){
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedBlog;
    }

    @Override
    public List<FirstPageBlog> getBlogByType(Long id)
    {
        return blogMapper.getFirstPageBlogByTypeId(id);
    }

    @Override
    public List<FirstPageBlog> getBlogByTag(Long id)
    {
        return blogMapper.getFirstPageBlogByTagId(id);
    }


}
