<%
            String userid=(String)session.getAttribute("u1id");
            if(userid==null)
            {
                response.sendRedirect("index.jsp");
            } 
            long l=session.getCreationTime();
            java.util.Date dt=new java.util.Date(l);
            out.print("youre session created :"+dt+"<br>");
            int n=session.getMaxInactiveInterval();
            out.print("your session out time : "+n/60+" minute");
%>
    
<html>
    <body>
        <h1>User Dashboard</h1>
        <hr>
        <pre>
            <a href="ActiveCase">ActiveCase</a>
            <a href="RecoverdCase">RecoverdCase</a>
            <a href="TotalDeath">TotalDeath</a>
            <a href="Endsession">Log-out</a>
        </pre>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
