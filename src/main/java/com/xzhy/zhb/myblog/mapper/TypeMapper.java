package com.xzhy.zhb.myblog.mapper;

import com.xzhy.zhb.myblog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNameTypeMapper
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/11 10:08
 * @Version V1.0
 **/
@Mapper
@Repository
public interface TypeMapper
{
    int saveType(Type type);

    Type getTypeById(Long id);

    Type getTypeByName(String name);

    List<Type> getAllByType();

    List<Type> getAdminType();

    int deleteType(Long id);

    int updateType(Type type);
}
