package org.blabla.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 实现非法用户过滤
 * Created by panting1 on 2017/8/26.
 */
public class FirstFilter implements Filter {
    // 在Web容器卸载 Filter 对象之前被调用。该方法在Filter的生命周期中仅执行一次。在这个方法中，可以释放过滤器使用的资源。
    public void destroy() {
        System.out.println("FirstFilter destroy");
    }

    // 项目启动时就已经进行读取，Init 方法在 Filter 生命周期中仅执行一次，web 容器在调用 init 方法时
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FirstFilter init!");
        //输出init参数
        for (Enumeration e = config.getInitParameterNames(); e
                .hasMoreElements();) {
            String name = (String) e.nextElement();
            String value = config.getInitParameter(name);
            System.out.println("name=" + name + " value=" + value);
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain)
    {
        //对请求执行处理
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        System.out.println("FirstFilter before URL: " + httpServletRequest.getRequestURL());

        //对相应进行处理 同理可以将resp转为HttpServletResponse处理
        HttpServletResponse httpServletResponse = (HttpServletResponse)resp;
        //暂时将重定向屏蔽掉，否则拦截器将无法执行
//        try {
//            //httpServletResponse.setCharacterEncoding("utf-8");//设置Response的编码方式为UTF-8
//            //httpServletResponse.setContentType("text/html;charset=ASCII");
//            httpServletResponse.sendRedirect("query");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //下一个filter
        try {
            chain.doFilter(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("FirstFilter after");
    }
}
