package org.blabla.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by panting1 on 2017/8/26.
 */
public class SecondFilter implements Filter {
    FilterConfig filterConfig;
    // 在Web容器卸载 Filter 对象之前被调用。该方法在Filter的生命周期中仅执行一次。在这个方法中，可以释放过滤器使用的资源。
    public void destroy() {
        System.out.println("SecondFilter destroy");
    }

    // 项目启动时就已经进行读取，Init 方法在 Filter 生命周期中仅执行一次，web 容器在调用 init 方法时
    public void init(FilterConfig config) throws ServletException {
        System.out.println("SecondFilter init");
        this.filterConfig = config;
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain)
    {
        System.out.println("SecondFilter before");
        try {
            chain.doFilter(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("SecondFilter after");
    }
}
