<%
   session.setMaxInactiveInterval(60*5);
   
%>
<html>
    <body>
        <h3>Session Example </h3>
        <hr>
        <form action="VerifyServlet" >
            Userid <input type="text" name="uid"/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
