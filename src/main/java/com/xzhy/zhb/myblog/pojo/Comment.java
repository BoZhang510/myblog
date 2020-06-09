package com.xzhy.zhb.myblog.pojo;

import com.xzhy.zhb.myblog.dto.DetailedBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameComment
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/27 17:34
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment
{
    private Long id;
    private String nickname;
    private String email;
    private String content;

    //头像
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;

    //回复评论 自关联
    //作为父类对象
    private List<Comment> replyComments = new ArrayList<>();
    //作为子类现象
    private Comment parentComment;

    private DetailedBlog blog;

}
