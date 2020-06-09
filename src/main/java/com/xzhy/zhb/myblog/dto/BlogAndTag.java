package com.xzhy.zhb.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassNameBlogAndTag
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/29 16:24
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndTag
{
    private Long tagId;
    private Long BlogId;
}
