package com.xzhy.zhb.myblog.dto;

import com.xzhy.zhb.myblog.pojo.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameDetailedBlog
 * @Description 博客详情
 * @Author zhangb181
 * @Date2020/4/29 14:50
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBlog
{
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer views;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    private List<Tag> tags = new ArrayList<>();
}
