<%
    int income=Integer.parseInt(request.getParameter("t1"));
    int age=Integer.parseInt(request.getParameter("t2"));
    int tax=0;
%>
<jsp:useBean id="bean" class="mypkg.TaxBean"/>
<jsp:setProperty name="bean" property="income" value="<%=income%>"/>
<jsp:setProperty name="bean" property="age" value="<%=age%>"/>
<html>
    <body>
        <h3>Tax Detail :</h3>
        <hr>
        <pre>
        Income : <jsp:getProperty name="bean" property="income"/>
        Age    : <jsp:getProperty name="bean" property="age"/>
        Tax    : <jsp:getProperty name="bean" property="tax"/>
        </pre>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
