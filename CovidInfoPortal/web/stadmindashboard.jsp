<%
   String id=(String)session.getAttribute("userid");
   if(id==null)
   {
     response.sendRedirect("index.jsp");
   }
%>
<html>
    <body>
        <h3>welcome state admin dashboard </h3>
        <hr>
        <pre>
        <a href="entrypage.jsp">Add-Info-For-Today</a>
        <a href="">Update-Info</a>
        <a href="StateDataServlet">View-Info-For-own-state</a>
        <a href="AllStateDataServlet">View-Info-For-All-state</a>
        <a href="EndSession">Log-out</a>
        </pre>
        <hr>
    </body>
</html>
<%@include file="info.jsp" %>
