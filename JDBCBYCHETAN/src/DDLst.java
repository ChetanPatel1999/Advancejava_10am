
import java.sql.Connection;
import java.sql.Statement;


public class DDLst {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
        //st.executeUpdate("create table dummy(frist_clm char,second_clm char)");
        st.executeUpdate("drop table dummy");
        con.close();
    }
 
}
