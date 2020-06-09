package com.xzhy.zhb.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassNameFirstPageBlog
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/4 11:10
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPageBlog
{
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //user
    private String nickname;
    private String avatar;
}
