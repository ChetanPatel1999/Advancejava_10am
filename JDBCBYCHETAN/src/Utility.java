
import java.sql.Connection;
import java.sql.DriverManager;


public class Utility {
      static public  Connection connect() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data10","root","root");
         return con;
    }
    
}
