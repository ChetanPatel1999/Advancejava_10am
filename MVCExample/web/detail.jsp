<jsp:useBean id="info" class="mypkg.Medicine" scope="session"/>
<html>
    <body>
        <h1>Medicine- Detail</h1>
        <hr>
        <pre>
            code  :<jsp:getProperty name="info" property="code"/>
            name  :<jsp:getProperty name="info" property="name"/>
            type  :<jsp:getProperty name="info" property="type"/>
            price :<jsp:getProperty name="info" property="price"/>
        </pre>
        <pre>
        <hr>
            <a href="search.jsp">Serch-More-Medicine</a>
            <a href="index.jsp">Home</a>
        </pre>
    </body>
</html>
