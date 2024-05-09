


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



public class StateAccountCreationservlet extends HttpServlet {
    public Connection con;
    public PreparedStatement ps;
    public void init()
    {
           try
           {
            //Class.forName("com.mysql.jdbc.Driver");
            //con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
            con=Utility.connect();
            String sql="insert into stateadmins values(?,?,?,null,null,null,null,'disable')";
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
        //StateAccountCreationservlet?uid=mpuser&password=india&state=MP
        String userid=request.getParameter("uid");
        String password=request.getParameter("password");
        String state=request.getParameter("state");
        PrintWriter out=response.getWriter();
        //process on data
        try
        {
            ps.setString(1, userid);
            ps.setString(2, password);
            ps.setString(3, state);
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
