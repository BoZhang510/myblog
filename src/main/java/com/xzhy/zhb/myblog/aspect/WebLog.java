package com.xzhy.zhb.myblog.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassNameWebLog
 * @Description TODO
 * @Author zhangb181
 * @Date2020/4/26 11:36
 * @Version V1.0
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog
{
    /*
    *
     * @Author zhangb181
     * @Description //日志信息描述
     * @Date 11:38 2020/4/26
     * @Param []
     * @return java.lang.String
     **/
    String blogDesc() default "";//定义一个属性，默认为空。
}
