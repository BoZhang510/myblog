package com.xzhy.zhb.myblog.service;

import com.xzhy.zhb.myblog.pojo.User;

/**
 * @ClassNameUserService
 * @Description 用户登录
 * @Author zhangb181
 * @Date2020/4/29 17:54
 * @Version V1.0
 **/
public interface UserService
{
    User checkUser(String name,String password);
}
