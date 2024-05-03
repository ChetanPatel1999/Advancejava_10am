
package mypkg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class startingeventhandler implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context object is created  ................@@@@ ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
          System.out.println("Context object is Destroyed  ................@@@@ ");
    }
}
