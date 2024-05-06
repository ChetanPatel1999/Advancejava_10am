<%
    
    String state=request.getParameter("t1");
    String contact="";
    switch(state)
    {
        case "mp":
            contact="333456";
            break;
        case "rj":
            contact="555456";
            break;
        case "mh":
            contact="999456";
            break; 
        default:
            contact="123456";
            break;
            
    }
       
%>    
<html>
    <body>
        <h3>Helpline Number for your state : <% out.print(state); %></h3>
        <h3>Number : <% out.print(contact); %></h3>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
