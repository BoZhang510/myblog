package com.xzhy.zhb.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassNameRecommendBlog
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/4 11:26
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendBlog
{
    private Long id;
    private String title;
    private boolean recommend;
}
