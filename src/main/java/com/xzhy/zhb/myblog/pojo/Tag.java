package com.xzhy.zhb.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameTag
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/27 17:34
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag
{
    private Long id;
    @NotEmpty(message = "标签名称不能为空")
    private String name;

    //博客和标签属于多对多关系
    private List<Blog> blogs = new ArrayList<>();
}
