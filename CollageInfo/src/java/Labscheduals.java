/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Labscheduals extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String cls="";
        // raed the cookies
        // step 1 -->fetch all cookies form comming with request.
        Cookie ck[]=request.getCookies();
        // step 2 -->search for the desired cookies
         for(Cookie c:ck)
         {
             String name=c.getName();
             if(name.equals("info"))
             {
                 cls=c.getValue();// cs-1,cs-11
                 break;
             }
         }
        out.print("<html><body><h3>");
        if(cls.equals("cs-1"))
        {
            out.print("Labscheduals of cs-1");
        }
        else if(cls.equals("cs-11"))
        {
            out.print("Labscheduals of cs-11");
        }
         else if(cls.equals("cs-111"))
        {
            out.print("Labscheduals of cs-111");
        }
        out.print("</h3><a href=index.jsp>Home</a>");
        out.print("</body></html></body><h3>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
