package databaseconnection;


import java.sql.Connection;
import java.sql.DriverManager;


public class Utility {
    public static Connection con;
    static public Connection connect()
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con =DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        return con;
    }
}
