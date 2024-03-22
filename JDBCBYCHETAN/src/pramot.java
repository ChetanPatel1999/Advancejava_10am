
import java.sql.Connection;
import java.sql.Statement;

public class pramot {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement st=con.createStatement();
       // st.executeUpdate("update student set sem=4 where rno=3 ");
       st.executeUpdate("update student set sem=sem+1 ");
        con.close();
    }
 
}
