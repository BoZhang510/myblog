package com.xzhy.zhb.myblog.service.impl;

import com.xzhy.zhb.myblog.mapper.TypeMapper;
import com.xzhy.zhb.myblog.pojo.Type;
import com.xzhy.zhb.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassNameTypeServiceImpl
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/11 10:03
 * @Version V1.0
 **/
@Service
public class TypeServiceImpl implements TypeService
{

    @Autowired
    private TypeMapper typeMapper;

    //事务注解
    @Transactional
    @Override
    public int saveType(Type type)
    {
        return typeMapper.saveType(type);
    }

    @Transactional
    @Override
    public Type getTypeById(Long id)
    {
        return typeMapper.getTypeById(id);
    }

    @Transactional
    @Override
    public Type getTypeByName(String name)
    {
        return typeMapper.getTypeByName(name);
    }

    @Transactional
    @Override
    public List<Type> getAllByType()
    {
        return typeMapper.getAllByType();
    }

    @Transactional
    @Override
    public List<Type> getAdminType()
    {
        return typeMapper.getAdminType();
    }

    @Transactional
    @Override
    public int updateType(Type type)
    {
        return typeMapper.updateType(type);
    }

    @Transactional
    @Override
    public int deleteType(Long id)
    {
        return typeMapper.deleteType(id);
    }
}
