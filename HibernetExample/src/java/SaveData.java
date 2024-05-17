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
import mypkg.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author CLASSROOM01
 */
public class SaveData extends HttpServlet {

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
       // read data from html form
       int rno=Integer.parseInt(request.getParameter("rno"));
       String name=request.getParameter("name");
       String branch=request.getParameter("branch");
       int sem=Integer.parseInt(request.getParameter("sem"));
               
       //set data in student type object
       Student st=new Student();
       st.setRno(rno);
       st.setName(name);
       st.setBranch(branch);
       st.setSem(sem);
       // save(st)
       //create configuration class object
       Configuration Config= new Configuration().configure();
       //create session object
       Session session=Config.buildSessionFactory().openSession();
       // create transaction object
       Transaction tr=session.beginTransaction();
       session.save(st);
       tr.commit();
       session.close();
       // response 
       PrintWriter out=response.getWriter();
       out.print("<html><body>");
       out.print("<h3>Recored Added</h3>");
       out.print("<pre>");
       out.print("<a href=Entry.jsp>Add-More-Student</a>");
       out.print("<a href=index.jsp>Home</a>");
       out.print("</pre>");
       out.print("</body></html>");
    }   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
