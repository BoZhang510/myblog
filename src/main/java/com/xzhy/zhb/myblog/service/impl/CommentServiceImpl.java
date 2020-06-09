package com.xzhy.zhb.myblog.service.impl;

import com.xzhy.zhb.myblog.mapper.BlogMapper;
import com.xzhy.zhb.myblog.mapper.CommentMapper;
import com.xzhy.zhb.myblog.pojo.Comment;
import com.xzhy.zhb.myblog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameCommentServiceImpl
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/5 10:25
 * @Version V1.0
 **/
@Service
public class CommentServiceImpl implements CommentService
{
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Comment> getCommentsById(Long id)
    {
        List<Comment> comments = commentMapper.getCommentsByBlogIdParentIdNull(id,Long.parseLong("-1"));
        return eachComment(comments);
    }

    @Override
    public int saveComment(Comment comment)
    {
        Long parentCommentId = comment.getParentCommentId();
        //没有父级评论默认为-1
        if (parentCommentId != -1){
            comment.setParentComment(commentMapper.findByParentCommentId(comment.getParentCommentId()));
        }
        else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        comment.setBlog(blogMapper.getDetailedBlog(comment.getBlogId()));
        return commentMapper.saveComment(comment);
    }

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    /**
     *
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComments();
            for(Comment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    private List<Comment> tempReplys = new ArrayList<>();

    /*
    *
     * @Author zhangb181
     * @Description //递归迭代,获取所有回复评论
     * @Date 15:11 2020/6/5
     * @Param [comment]
     * @return void
     **/
    private void recursively(Comment comment){
        tempReplys.add(comment);
        if (comment.getReplyComments().size()>0){
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply:replys){
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0){
                    recursively(reply);
                }
            }
        }
    }
}
