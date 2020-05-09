package com.xzhy.zhb.myblog.handle;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomExceptionHandle
 * @Description 全局异常处理
 * @Author zhangb181
 * @Date2020/4/22 14:47
 * @Version V1.0
 **/
//@ControllerAdvice 是Controller的加强版，主要用来处理全局数据，
// 搭配@ExceptionHandler处理全局异常

@ControllerAdvice
@Slf4j
public class CustomExceptionHandle
{
    //使用@Slf4j 省略这一繁杂代码
    // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExampleOther.class);
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(HttpServletRequest request,Exception e) throws Exception
    {
        //{}是占位符
        log.error("Request URL:{},Exception:{}",request.getRequestURL(),e);
        if (AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURI());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }
}