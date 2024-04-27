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
public class Timetable extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //read data from client
        String cls=request.getParameter("class");
        //step 1 --> create cookies object
        Cookie ck=new Cookie("info",cls);//cs-1 (name-value pair)
        //step 2 --> specify the maximum age limit of the cookies
        ck.setMaxAge(60*60*24*7);//one week
        //step 3 --> add this Cookies with response object
        response.addCookie(ck);
        PrintWriter out=response.getWriter();
        out.print("<html><body><h3>");
        if(cls.equals("cs-1"))
        {
            out.print("Time Table of cs-1");
        }
        else if(cls.equals("cs-11"))
        {
            out.print("Time Table of cs-11");
        }
         else if(cls.equals("cs-111"))
        {
            out.print("Time Table of cs-111");
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
