


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SaveInfo extends HttpServlet {
    public Connection con;
    public PreparedStatement ps;
    public void init()
    {
           try
           {
            //Class.forName("com.mysql.jdbc.Driver");
            //con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
            con=Utility.connect();
            String sql="insert into covidinfo(idate,state,total,active,death,userid) values(now(),?,?,?,?,?)";
            ps=con.prepareStatement(sql);
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
        //read data from client
        //SaveInfo?state=&uid=&total=&active=&death=
       // String userid=request.getParameter("uid");
        //String state=request.getParameter("state");
        int total=Integer.parseInt(request.getParameter("total"));
        int active=Integer.parseInt(request.getParameter("active"));
        int death=Integer.parseInt(request.getParameter("death"));
        //read data from session object
        HttpSession session=request.getSession();
        String userid=(String)session.getAttribute("userid");
        String state=(String)session.getAttribute("state");
        //java.util.Date dt =new java.util.Date();
       // long val=dt.getTime();
       // java.sql.Date idate=new java.sql.Date(val);
        PrintWriter out=response.getWriter();
        //process on data
        try
        {
            //idate,state,total,active,death,userid
            //ps.setDate(1, idate);
            ps.setString(1, state);
            ps.setInt(2, total);
            ps.setInt(3, active);
            ps.setInt(4, death);
            ps.setString(5, userid);
            ps.executeUpdate();
            //response send
            out.print("<html><body>");
            out.print("<h3>submit covid data successfully</h3>");
            out.print("<hr><h3><a href=stadmindashboard.jsp >Dashboard </a></h3><hr>");
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
