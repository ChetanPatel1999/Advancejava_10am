import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dataretrieve2 {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
        String sql="select *from student ";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
         String s1=rs.getString(1);
        
         System.out.println(s1);
        }
        rs.beforeFirst();
        while(rs.next())
        {
         String s2=rs.getString(2);
        
         System.out.println(s2);
        }
        rs.absolute(2);
        System.out.println(rs.getString("name"));
        
        
    }
}
