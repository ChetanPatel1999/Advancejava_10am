
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class PreparedStatementExample2 {
    public static void main(String[] args) throws Exception {
        Connection con = Utility.connect();
        String name,branch;
        int rno,sem;
        Scanner sc= new Scanner(System.in);
        System.out.print("enter rno: ");
        rno=sc.nextInt();
        System.out.print("enter name: ");
        name=sc.next();
        System.out.print("enter branch: ");
        branch=sc.next();
        System.out.print("enter sem: ");
        sem=sc.nextInt();
        PreparedStatement st= con.prepareStatement("insert into student values(?,?,?,?)");
        st.setInt(1, rno);
        st.setString(2, name); 
        st.setString(3, branch);
        st.setInt(4, sem);
        st.executeUpdate();
        con.close();
    }
}
