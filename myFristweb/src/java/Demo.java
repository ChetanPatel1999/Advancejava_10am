/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {

  public void init()
  {
      // this is called when demo servelt loded on server
      System.out.println("init is called by chetan .......");
  }
  public void destroy()
  {
      // this is called when unlode servlet from server conntainer
      System.out.println("destroy is called by chetan .......");
  }
  public void doGet(HttpServletRequest request , HttpServletResponse response)
  {
      //when request is get type
      System.out.println("doget is called by chetan .......");
  }
  public void doPost(HttpServletRequest request , HttpServletResponse response)
  {
      //when request is post type
      System.out.println("dopost is called by chetan .......");
  }
}
