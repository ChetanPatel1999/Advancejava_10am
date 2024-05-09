<%-- traditional approch --%>
<%
    int income=Integer.parseInt(request.getParameter("t1"));
    int age=Integer.parseInt(request.getParameter("t2"));
    int tax=0;
    mypkg.TaxBean bean= new mypkg.TaxBean();
    bean.setIncome(income);
    bean.setAge(age);
%>
<html>
    <body>
        <h3>Tax Detail :</h3>
        <hr>
        <pre>
        Income : <%=bean.getIncome()%>
        Age    : <%=bean.getAge()%>
        Tax    : <%=bean.getTax()%>
        </pre>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
