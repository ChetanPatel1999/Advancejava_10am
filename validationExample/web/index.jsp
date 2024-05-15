<html>
    <body>
        <h1>Validation-Example</h1>
        <h3>Data-Entry-Form</h3>
        <form action="DataProcessing">
            <pre>
             Name :<input type="text"  name="t1"/><%= request.getAttribute("nameErr")%>
             Age  :<input type="text"  name="t2"/><%= request.getAttribute("ageErr")%>
                  <input type="submit" value="Submit"/>
            </pre>
        </form>
        
    </body>
</html>
