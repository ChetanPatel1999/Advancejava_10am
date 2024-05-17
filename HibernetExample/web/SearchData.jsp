<%@page import="mypkg.Student"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%
    int rno=Integer.parseInt(request.getParameter("rno"));
    Configuration con=new Configuration().configure();
    Session ses=con.buildSessionFactory().openSession();
    Transaction tr=ses.beginTransaction();
    Student st=(Student)(ses.get(Student.class,rno));
    tr.commit();
    ses.close();
%>    
<html>
    <body>
        <h1>Studet-Info</h1>
        <pre>
            Name   :<%=st.getName()%>
            Rno    :<%=st.getRno()%>
            Branch :<%=st.getBranch()%>
            Sem    :<%=st.getSem()%>
        </pre>
    <hr>
    <pre>
        <a href="serach.jsp">Search-More-Student</a>
        <a href="index.jsp">Home</a>
    </pre>
     </body>
</html>
