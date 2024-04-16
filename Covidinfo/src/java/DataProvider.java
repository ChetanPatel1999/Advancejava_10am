
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataProvider extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //reade data
        String country=request.getParameter("country");
        String name=request.getParameter("name");
        String items[]=request.getParameterValues("donation");// 
        String color=request.getParameter("bgcolor");
        //process on data
        int totalCase=0;
        int activeCase=0;
        int totalDeath=0;
        switch(country)
        {
            case "india":
                 totalCase=2000;
                 activeCase=1500;
                 totalDeath=500; 
                 break;
            case "uk":
                 totalCase=5000;
                 activeCase=4500;
                 totalDeath=500; 
                 break;
            case "us":
                 totalCase=10000;
                 activeCase=9500;
                 totalDeath=500; 
                 break;
        }
         //provide the response
         PrintWriter out=response.getWriter();
          out.println("<html>");
          out.println("<body bgcolor = "+color+">");
          out.println("<h3>welcome to my site "+name+"</h3>");
          out.println("<h4>covide information about "+country+" ....</h4>");
          out.println("<table border =2>");
          out.println("<tr>");
          out.println("<td>TotalCase</td>");
          out.println("<td>"+totalCase+"</td>");
          out.println("</tr>");
          out.println("<tr>");
          out.println("<td>activeCase</td>");
          out.println("<td>"+activeCase+"</td>");
          out.println("</tr>");
          out.println("<tr>");
          out.println("<td>TotalDeath</td>");
          out.println("<td>"+totalDeath+"</td>");
          out.println("</tr>");
          out.println("</table>");
          out.println("<h3>Donation by "+name+"</h3>");
          out.println("<ol>");// this tag make list
          for(String item :items)
          {
              out.println("<li>");
              out.println(item);
              out.println("</li>");
          }
          out.println("</ol>");
          out.println("<marquee><h3>Stay At Home ,Be Safe</h3></marquee>");//display scrol text
          out.println("</body>");
          out.println("</html>");
    }

    
}
