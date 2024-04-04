import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class fetchmultpletableusingresultset{
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
        //ResultSet rs=st.executeQuery("select ename,ptitle from emp,project where emp.pcode=project.pcode");
        ResultSet rs=st.executeQuery("select desg,sum(sal) from emp group by desg");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+" "+ rs.getString(2));
        }
        con.close();
        
}
}
