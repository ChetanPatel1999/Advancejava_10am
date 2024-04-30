/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CLASSROOM01
 */
public class StateDataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session=request.getSession();
          String userid=(String)session.getAttribute("userid");
          String state=(String)session.getAttribute("state");
          PrintWriter out=response.getWriter();
          try
          {
            Connection con=Utility.connect();
            String sql="select * from covidinfo where userid =?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, userid);
            ResultSet rs=st.executeQuery();
            out.print("<html><body>");
            out.print("<h3>covid info of "+state+"</h3>");
            out.print("<table border=2>");
            out.print("<tr><td>sno</td><td>date</td><td>total</td><td>active</td><td>death</td></tr>");
            while(rs.next())
            {
                String sno=rs.getString("sno");
                String date=rs.getString("idate");
                String total=rs.getString("total");
                String active=rs.getString("active");
                String death=rs.getString("death");
                out.print("<tr><td>"+sno+"</td><td>"+date+"</td><td>"+total+"</td><td>"+active+"</td><td>"+death+"</td></tr>");
            }
            out.print("</table>");
            out.print("<hr><a href=stadmindashboard.jsp>Dashboard</a>");
            out.print("</body></html>");
          }
          catch(Exception e)
          {
              out.print(e);
          }
          
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
