package com.xzhy.zhb.myblog.dto;

import com.xzhy.zhb.myblog.pojo.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassNameBlogQuery
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/29 15:34
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery
{
    private Long id;
    private String title;
    private Date updateTime;
    private Integer recommend;
    private Long typeId;

    private Type type;
}