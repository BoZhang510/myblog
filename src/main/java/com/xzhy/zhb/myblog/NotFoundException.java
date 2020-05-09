package com.xzhy.zhb.myblog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassNameNotFoundException
 * @Description 自定义的异常处理
 * @Author zhangb181
 * @Date2020/4/24 17:16
 * @Version V1.0
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super();
    }

    public NotFoundException(String message)
    {
        super(message);
    }

    public NotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
