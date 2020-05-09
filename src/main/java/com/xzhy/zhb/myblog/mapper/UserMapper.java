package com.xzhy.zhb.myblog.mapper;

import com.xzhy.zhb.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassNameUserDao
 * @Description 根据用户名，密码检查账户
 * @Author zhangb181
 * @Date2020/5/1 10:05
 * @Version V1.0
 **/
@Mapper
@Repository
public interface UserMapper
{
    User queryAccountByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
