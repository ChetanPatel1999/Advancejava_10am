
package mypkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicineDAO {
    private Connection con;
    public MedicineDAO()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root");
            System.out.println("connection succefully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void savemedicine(Medicine medicine)
    {
        try
        {
            PreparedStatement st=con.prepareStatement("insert into medicines values (?,?,?,?)");
            st.setInt(1,medicine.getCode());
            st.setString(2,medicine.getName());
            st.setString(3,medicine.getType());
            st.setInt(4,medicine.getPrice());
            st.executeUpdate();
            System.out.println("data save success fully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public Medicine SearchMedicine(int code)
    {
        Medicine medicine=new Medicine();
         try
        {
            PreparedStatement st=con.prepareStatement("select *from medicines where code=?");
            st.setInt(1,code);
            ResultSet rs=st.executeQuery();
            rs.next();
            medicine.setCode(rs.getInt(1));
            medicine.setName(rs.getString(2));
            medicine.setType(rs.getString(3));
            medicine.setPrice(rs.getInt(4));
            System.out.println("search succefully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
         return medicine;
    }
     public void deleteMedicine(int code)
    {
          try
        {
            PreparedStatement st=con.prepareStatement("delete from medicines where code = ?");
            st.setInt(1,code);
            st.executeUpdate();
            System.out.println("delete succefully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
      public void updateMedicine()
    {
        
    }
      /*
    public static void main(String[] args) {
        MedicineDAO o1=new MedicineDAO();
        o1.deleteMedicine(1001);
        Medicine medicine=o1.SearchMedicine(1001);
        System.out.println(medicine.getCode());
        System.out.println(medicine.getName());
        System.out.println(medicine.getType());
        System.out.println(medicine.getPrice());
        Medicine medicine=new Medicine(1001,"aaa","t1",50);
        o1.savemedicine(medicine);
    }*/
}
