package com.xzhy.zhb.myblog.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassNameMyBeanUtils
 * @Description TODO
 * @Author zhangb181
 * @Date2020/6/4 10:05
 * @Version V1.0
 **/
public class MyBeanUtils
{
    /*
    *
     * @Author zhangb181
     * @Description 获取实体类属性为null属性的属性数组
     * @Date 10:05 2020/6/4
     * @Param 
     * @return 
     **/
    public static String[] getNullPropertyName(Object source){
        //使用BeanWrapper封装传入的类
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        //获取Bean所有的属性定义
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd: pds){
            Object beanValue = beanWrapper.getPropertyValue(pd.getName());
            if (beanValue == null){
                emptyNames.add(pd.getName());
            }
        }
        String [] results = new String[emptyNames.size()];
        return emptyNames.toArray(results);
    }
}
