
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
        String country=request.getParameter("t1");
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
         out.println("thanks for visiting .......");
         out.println("TotalCase in "+country+" : "+totalCase);
         out.println("ActiveCase in "+country+" : "+activeCase);
         out.println("TotalDeath in "+country+" : "+totalDeath);
    }

    
}
