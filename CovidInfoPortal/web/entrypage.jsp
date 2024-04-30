<%
   String id=(String)session.getAttribute("userid");
   if(id==null)
   {
     response.sendRedirect("index.jsp");
   }
%>
<html>
    <body>
        <h3>Submit-Info-For-Today</h3>
        <hr>
        <form action="SaveInfo">
         <pre>   
   TotalCase  <input type="text" name="total"/>
   ActiveCase <input type="text" name="active"/>
   TotalDeath <input type="text" name="death"/>

              <input type="submit" value="Submit"/>  
         </pre>  
        </form>
        <hr>
        <a href="stadmindashboard.jsp">Dashboard</a>
    </body>
</html>
