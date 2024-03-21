import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class JDBCExample1 {
    public static void main(String[] args)  {
        
        try
        {
            // step 1 driver loading
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loded successfully");
            // step 2 connection establishmenet
            String uid="root";
            String upass="root";
            String url="jdbc:mysql://localhost:3306/data10";
            Connection con=DriverManager.getConnection(url,uid,upass);
            System.out.println("connectioin succesfully");
            // step 3 : create  statement/prepared statement object to dispatch(send) sql to DB.
            Statement stm=con.createStatement();
            // stap 4 :send sql to DB
            String sql="insert into student values(4,'DDD','cs',7)";
            int n=stm.executeUpdate(sql);
            System.out.println(n +" row affected");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
