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
            String sql1="insert into student values(1,'AAA','cs',7)";
            String sql2="insert into student values(2,'BBB','cs',5)";
            String sql3="insert into student values(3,'CCC','civil',6)";
            String sql4="insert into student values(4,'DDD','me',2)";
            String sql5="insert into student values(5,'EEE','cs',4)";
            stm.executeUpdate(sql1);
            stm.executeUpdate(sql2);
            stm.executeUpdate(sql3);
            stm.executeUpdate(sql4);
            stm.executeUpdate(sql5);
            con.close();
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
