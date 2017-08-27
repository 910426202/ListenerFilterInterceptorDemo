package org.blabla.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by panting1 on 2017/8/27.
 */
public class FirstServletRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent var1){
        System.out.println("FirstServletRequestListener requestDestroyed URL ");
    }

    public void requestInitialized(ServletRequestEvent var1){
        HttpServletRequest httpServletRequest = (HttpServletRequest)var1.getServletRequest();
        System.out.println("FirstServletRequestListener requestInitialized URL " + httpServletRequest.getRequestURL());
    }
}
