<%@taglib uri= "/WEB-INF/tlds/lib1.tld" prefix="mytag" %>
<html>
    <body>
        <h3>Welcome Covid Info-Portal </h3>
        <mytag:totalcases/>
        <form action="Verifyuser" method="get">
            <table >
             <tr>
            <td>Email/Uid </td><td><input type="text" name="uid"/></td>
             </tr>
             <tr>
                 <td> Password</td><td> <input type="text" name="password"/></td>
             </tr>
            <tr>
                <td>Utype</td> <td> <select name="utype">
                   <option>enduser</option>
                   <option>super-admin</option>
                   <option>state-admin</option>
                    </select>
                </td>
            </tr>
             <tr>
                 <td><input type="submit" value="Log-in"/></td><td><input type="reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="registration.jsp">new user Registration</a><br>
        <a href="helpline.jsp">Covid-Helpline-Number</a>
        <hr>
    </body>
</html>
<%@include file="info.jsp" %>
