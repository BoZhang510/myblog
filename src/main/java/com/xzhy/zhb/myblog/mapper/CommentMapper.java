package com.xzhy.zhb.myblog.mapper;

import com.xzhy.zhb.myblog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNameCommentMapper
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/5 10:28
 * @Version V1.0
 **/
@Mapper
@Repository
public interface CommentMapper
{
    //根据创建时间倒叙来排序
    List<Comment> getCommentsByBlogIdParentIdNull(@Param("blogId") Long id,@Param("blogParentId") Long blogParentId);

    //查询父级对象
    Comment findByParentCommentId(Long parentCommentId);

    //添加评论
    int saveComment(Comment comment);
}
