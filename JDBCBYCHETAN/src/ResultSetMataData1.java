import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class ResultSetMataData1{
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
        String sql="select *from student ";
        ResultSet rs=st.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        int n= rsmd.getColumnCount();
        for(int i=1;i<=n;i++)
        {
            System.out.print(rsmd.getColumnName(i)+ " ");
        }
        System.out.println();
        while(rs.next())
        {
            for(int i=1;i<=n;i++)
            {
                System.out.print(rs.getString(i)+"  ");
            }
            System.out.println();
        }
        
        
      
        
        
    }
}

