<%
    String sql="select *from covidinfo";
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root"); 
    java.sql.Statement st=con.createStatement();
    java.sql.ResultSet rs=st.executeQuery(sql);
%>
<html>
    <body>
        <h1>Covid Cases of all state : </h1>
        <table border="2">
            <tr><td>sno</td><td>date</td><td>state</td><td>total</td><td>active</td><td>death</td></tr>
             <%
                while(rs.next())
                {
                    String sno=rs.getString(1);
                    String date=rs.getString(2);
                    String state=rs.getString(3);
                    String total=rs.getString(4);
                    String active=rs.getString(5);
                   // String death=rs.getString(6);
              %>  
              <tr>
                  <td><%=sno%></td>
                  <td><%=date%></td>
                  <td><%=state%></td>
                  <td><%=total%></td>
                  <td><%=active%></td>
                  <td><%=rs.getString(6)%></td>   
              </tr>
              <%
                }
              %>
        </table>
        <hr>
        <a href="userdashboard.jsp">Dashboard</a>
    </body>
</html>
