package com.xzhy.zhb.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassNameBlog
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/27 15:48
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog
{
    private Long id;
    private String title;
    private String content;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    //这个属性用来mybatis中进行连接查询
    private Long typeId;
    private Long userId;

    //获取多个标签的id
    private String tagIds;
    private String description;
}
