/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author CLASSROOM01
 */
public class sessionhandle implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("one new user is come .........######");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("one  user is leave .........######");
   }
}
