
package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class Databaseconnectionhandle implements ServletContextListener {
 private Connection con;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
           ServletContext context=sce.getServletContext();
           context.setAttribute("dbcon", con);
           System.out.println("data base connection succesfully...........@@@@");
        }
        catch(Exception e)
        {
            System.out.println("data base connection exception...........@@@@");
        }
        
   }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try
        {
            con.close();
        System.out.println("data base connection close succesfully...........@@@@");
        }
        catch(Exception e)
        {
             System.out.println("data disconnection Exception...........@@@@");
        }
    }
}
