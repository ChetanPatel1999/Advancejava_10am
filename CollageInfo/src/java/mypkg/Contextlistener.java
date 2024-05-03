
package mypkg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Contextlistener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context object Created ...............@@@");
   }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context object destroye ...............@@@");
    }
}
