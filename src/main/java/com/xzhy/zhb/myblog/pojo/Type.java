package com.xzhy.zhb.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameType
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/27 17:35
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type
{
    private Long id;
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    private List<Blog> blogs = new ArrayList<>();
}
