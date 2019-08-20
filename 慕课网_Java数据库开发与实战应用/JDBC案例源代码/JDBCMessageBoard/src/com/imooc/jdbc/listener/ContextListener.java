package com.imooc.jdbc.listener;

import com.imooc.jdbc.cache.UserLocalCache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * TODO {file desc}
 *
 * @version 1.0
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserLocalCache.init();
        System.out.println("Init ContextListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        UserLocalCache.destroy();
        System.out.println("Destroyed ContextListener");
    }

}
