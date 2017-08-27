package org.blabla.Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by panting1 on 2017/8/27.
 */
public class FirstHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent var1){
        //HttpServletRequest httpServletRequest = (HttpServletRequest)var1.getSession().getServletContext()
        var1.getSession().setMaxInactiveInterval(5);//会话超时时间5s，超过5s无操作则销毁会话sessionDestroyed就会被自动调用
        System.out.println("FirstHttpSessionListener sessionCreated " + var1.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent var1){
        System.out.println("FirstHttpSessionListener sessionDestroyed " + var1.getSession().getId());
    }
}
