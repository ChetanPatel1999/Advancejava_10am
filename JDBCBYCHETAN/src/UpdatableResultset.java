import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UpdatableResultset{
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String sql="select *from student ";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println(s1+" "+s2+" "+s3+" "+s4);
        }
        // udate data in database using resultset object
        rs.absolute(2);
        rs.updateString(2, "shyam");
        rs.updateRow();
        rs.beforeFirst();
          while(rs.next())
        {
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println(s1+" "+s2+" "+s3+" "+s4);
        }
    }
}

