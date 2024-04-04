import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UpdatableResultset2{
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
        // insert data in database using resultset object
        rs.moveToInsertRow();
        rs.updateInt("rno", 114);
        rs.updateString("name", "jayesh");
        rs.updateString("branch", "Ec");
        rs.updateInt("sem", 6);
        rs.insertRow();
        System.out.println("print table after insert :- ");
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