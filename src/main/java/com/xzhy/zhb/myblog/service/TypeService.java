package com.xzhy.zhb.myblog.service;

import com.xzhy.zhb.myblog.pojo.Type;

import java.util.List;

/**
 * @ClassNameTypeService
 * @Description 博客类别管理
 * @Author zhangb181
 * @Date2020/5/11 9:49
 * @Version V1.0
 **/
public interface TypeService
{
    int saveType(Type type);

    Type getTypeById(Long id);

    Type getTypeByName(String name);

    List<Type> getAllByType();

    List<Type> getAdminType();

    int updateType(Type type);

    int deleteType(Long id);
}