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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLASSROOM01
 */
public class Verifyuser extends HttpServlet {
   private Connection con;
   private PreparedStatement ps1;
  public void init()
    {
           try
           {
            //Class.forName("com.mysql.jdbc.Driver");
            //con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
            con=Utility.connect();
            String sql="select *from users where email=? and password=?";
            ps1=con.prepareStatement(sql);
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
    }
      public void destroy()
    {
        try
        {
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //read data
        //uid=aaa%40gmail.com&password=1234&utype=enduser
        String id=request.getParameter("uid");
        String pw=request.getParameter("password");
        String utype=request.getParameter("utype");
        PrintWriter out=response.getWriter();
        if(utype.equals("super-admin"))
        {
            if(id.equals("sadmin") && pw.equals("ssi"))
            {
               //response.sendRedirect("sadmindashboard.jsp");
               RequestDispatcher rd=request.getRequestDispatcher("sadmindashboard.jsp");
               rd.forward(request, response);
            }
            else
            {
                out.print("<html><body>");
                out.print("<h3>Invalid user account</h3>");
                out.print("<hr><h3><a href=index.jsp>Try-again</a></h3><hr>");
                out.print("</body></html>");
                
            }
           
        }
        else if(utype.equals("state-admin"))
        {
            response.sendRedirect("stadmindashboard.jsp");
        }
        else if(utype.equals("enduser"))
        {
            try
            {
                 ps1.setString(1, id);
                 ps1.setString(2, pw);
                 ResultSet rs=ps1.executeQuery();
                 boolean found= rs.next();
                 if(found)
                 {
                     response.sendRedirect("userdashboard.jsp");
                 }
                 else
                 {
                     out.print("<html><body>");
                     out.print("<h3>Invalid user account</h3>");
                     out.print("<hr><h3><a href=index.jsp>Try-again</a></h3><hr>");
                     out.print("</body></html>");
                     
                 }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
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
