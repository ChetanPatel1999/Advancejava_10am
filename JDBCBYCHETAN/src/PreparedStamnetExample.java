
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class PreparedStamnetExample {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Scanner sc= new Scanner(System.in);
        int rno;
        System.out.print("enter rno : ");
        rno=sc.nextInt();
        PreparedStatement st=con.prepareStatement("delete from student where rno=?");
        st.setInt(1, rno);
        st.executeUpdate();
        con.close();
       
    }
 
}
