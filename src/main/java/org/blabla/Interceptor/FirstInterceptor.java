package org.blabla.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panting1 on 2017/8/27.
 */
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    /*
     *预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器（如我们上一章的Controller实现）；
     *返回值：true表示继续流程（如调用下一个拦截器或处理器）；
     *     false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    public boolean preHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3) throws Exception{
        System.out.println("FirstInterceptor preHandle Reuquest URL: " + var1.getRequestURL());
        return true;
    }

    /**
     * 在控制器后处理 反序执行
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{
        System.out.println("FirstInterceptor postHandle Request URL: " + var1.getRequestURL());
        //var2.sendRedirect("query");//继续重定向
    }

    @Override
    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{
        System.out.println("FirstInterceptor afterCompletion");
    }

}
