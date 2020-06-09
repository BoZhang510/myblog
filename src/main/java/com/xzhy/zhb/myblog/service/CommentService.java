package com.xzhy.zhb.myblog.service;

import com.xzhy.zhb.myblog.pojo.Comment;

import java.util.List;

/**
 * @ClassNameCommentService
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/5 10:23
 * @Version V1.0
 **/
public interface CommentService
{
    List<Comment> getCommentsById(Long id);
    int saveComment(Comment comment);
}
