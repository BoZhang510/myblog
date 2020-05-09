package com.xzhy.zhb.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameUser
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/27 17:35
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private Long id;
    private String nickName;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    //一对多，一个人可以有多篇博客
    private List<Blog> blogs = new ArrayList<>();
}
