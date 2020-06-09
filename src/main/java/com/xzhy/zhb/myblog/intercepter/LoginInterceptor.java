package com.xzhy.zhb.myblog.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassNameLoginInterceptor
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/6 14:20
 * @Version V1.0
 **/
public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        System.out.println("当前用户----"+request.getSession().getAttribute("user"));
        if(request.getSession().getAttribute("user") == null ){
            response.sendRedirect("/admin");
            System.out.println("拦截了");
            return false;
        }
        return true;
    }

}
