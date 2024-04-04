
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dataretrieve {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
        String sql="select *from student ";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
       // String s1=rs.getString("rno");//String s1=rs.getString(1);
        int s1=rs.getInt("rno");
        String s2=rs.getString("name");// String s2=rs.getString(2);
        String s3=rs.getString("branch");//String s3=rs.getString(3);
        String s4=rs.getString("sem");//String s4=rs.getString(4);
        System.out.println(s1+ " "+s2+ " "+s3+ " "+s4);
        }
        
        
    }
}
