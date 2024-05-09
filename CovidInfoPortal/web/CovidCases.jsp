<%@page import="java.sql.Connection,java.sql.Statement" errorPage="myerror.jsp" %>
<%@page import="java.sql.ResultSet" %>
 <%@taglib uri="/WEB-INF/tlds/lib1.tld" prefix="myt" %>
<%!
    int deathPercent(int total,int death)
    {
        int dp=(death*100)/total;
        return dp;
    }
%>    
<%
    String sql="select *from covidinfo";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root"); 
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(sql);
%>
<html>
    <body>
        <h1>Covid Cases of all state : </h1>
        <table border="2">
            <tr><td>sno</td><td>date</td><td>state</td><td>total</td><td>active</td><td>death</td><td>death percent</td></tr>
             <%
                while(rs.next())
                {
                    String sno=rs.getString(1);
                    String date=rs.getString(2);
                    String state=rs.getString(3);
                    int total=rs.getInt(4);
                    String active=rs.getString(5);
                    int death=rs.getInt(6);
              %>  
              <tr>
                  <td><%=sno%></td>
                  <td><%=date%></td>
                  <td><%=state%></td>
                  <td><%=total%></td>
                  <td><%=active%></td>
                  <td><%=rs.getString(6)%></td>   
                  <td><%=deathPercent(total,death)+"%"%></td>  
              </tr>
              <%
                }
              %>
        </table>
     <myt:totalcases/>
        <hr>
        <a href="userdashboard.jsp">Dashboard</a>
    </body>
</html>
