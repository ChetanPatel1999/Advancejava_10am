import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class DATAremove {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data10","root","root");
        Statement st=con.createStatement();
        st.executeUpdate("delete from student where rno=2");
        con.close();
        
    }
}
