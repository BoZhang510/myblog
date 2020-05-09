package com.xzhy.zhb.myblog.service.impl;

import com.xzhy.zhb.myblog.mapper.UserMapper;
import com.xzhy.zhb.myblog.pojo.User;
import com.xzhy.zhb.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameUserServiceImpl
 * @Description
 * @Author zhangb181
 * @Date2020/4/30 10:07
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    public User checkUser(String username,String password){
        User user = userMapper.queryAccountByNameAndPassword(username,password);
        return user;
    }
}
