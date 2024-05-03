
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author CLASSROOM01
 */
public class requesthandle implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
         System.out.println(" provide response...........********");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("new request is send...........********");
   }
}
