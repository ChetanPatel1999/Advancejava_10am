

<html>
    <body>
        <h3>State-Account-Creation-Form</h3>
       
        <form action="StateAccountCreationservlet" method="get">
            <table >
             <tr>
            <td>Userid</td><td><input type="text" name="uid"/></td>
             </tr>
             <tr>
                 <td> Password</td><td> <input type="text" name="password"/></td>
             </tr>
            <tr>
                <td>State</td> <td> <select name="state">
                   <option>AP</option>
                   <option>MP</option>
                   <option>MH</option>
                   <option>RJ</option>
                    </select>
                </td>
            </tr>
             <tr>
                 <td><input type="submit" value="Create-Account"/></td><td><input type="reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
        <hr>
    </body>
</html>

