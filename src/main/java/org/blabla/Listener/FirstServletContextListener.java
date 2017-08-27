package org.blabla.Listener;

import javax.servlet.ServletContextEvent;

/**
 * Created by panting1 on 2017/8/27.
 */
public class FirstServletContextListener extends org.springframework.web.context.ContextLoaderListener {
    //容器启动时调用
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        System.out.println("FirstServletContextListener contextInitialized " +
                event.getServletContext().getServletContextName());//Spring MVC Application
    }

    //容器销毁时调用
    public void contextDestroyed(ServletContextEvent event) {
       super.contextDestroyed(event);
        System.out.println("FirstServletContextListener contextDestroyed");
    }
}
