<%
    java.util.Date dt=new java.util.Date();
    String str=dt.toString();
%>
<%@taglib uri="/WEB-INF/tlds/lib1" prefix="mytag"%>
<html>
    <body>
        <h1>Custom tag Example </h1>
        Current Date and Time :<mytag:today/>
    </body>
</html>
