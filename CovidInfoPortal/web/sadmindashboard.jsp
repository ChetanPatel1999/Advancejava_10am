<%
   String id=(String)session.getAttribute("userid");
   if(id==null)
   {
     response.sendRedirect("index.jsp");
   }
%>
<html>
    <body>
        <h3>Welcome super-admin dashbord</h3>
        <hr>
        <pre>
        <a href="State-account.jsp">Create-state-account</a>
        <a href="">view-state-account</a>
        <a href="">view-user-account</a>
        <a href="">view-all-state</a>
        <a href="EndSession">Long-out</a>
        </pre>
        <hr>
    </body>
</html>
