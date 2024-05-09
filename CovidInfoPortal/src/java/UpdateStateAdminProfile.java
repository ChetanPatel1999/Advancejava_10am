


import databaseconnection.Utility;
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
public class UpdateStateAdminProfile extends HttpServlet {
    public Connection con;
    public PreparedStatement ps;
    public void init()
    {
           try
           {
            //Class.forName("com.mysql.jdbc.Driver");
            //con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
            con=Utility.connect();
            String sql="update stateadmins set password=?,uname=?,email=?,address=?,mobile=?,status='enable' where userid=?";
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
       // UpdateStateAdminProfile?uid=mpuser&password=mpindia&uname=manish&address=indore&email=manish%40gmail.com&mobile=09678345667
        String userid=request.getParameter("uid");
        String password=request.getParameter("password");
        String name=request.getParameter("uname");
        String address=request.getParameter("address");
        String mobile=request.getParameter("mobile");
        String email=request.getParameter("email");
        PrintWriter out=response.getWriter();
        //process on data
        try
        {
            //update stateadmins set password=?,uname=?,email=?,address=?,mobile=?,status='enable' where userid=?";
            ps.setString(1, password);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, mobile);
            ps.setString(6, userid);
            ps.executeUpdate();
            //response send
            out.print("<html><body>");
            out.print("<h3>registration successfully</h3>");
            out.print("<hr><h3><a href = index.jsp >Login -Now </a></h3><hr>");
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
