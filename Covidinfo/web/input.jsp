
<html>
    <body>
        <h3>Get-Covid-detaile-About-Country</h3>
        <h4>Please-Provide-Country-Name</h4>
        <form action="DataProvider" method="get">
            <pre>
            Output-bkground  pink <input type="radio" name="bgcolor" value="pink" checked="check"/>  gray <input type="radio" name="bgcolor" value="gray"/> 

            your-Name <input type="text" name="name"/>

            Country-name <select name="country">
                          <option>india</option>
                          <option>uk</option>
                           <option>us</option>
                          </select>
<!--
            Donation <select name="donation" multiple="multiple">
                          <option>mask</option>
                          <option>ppe</option>
                           <option>vaccine</option>
                           <option>medicine</option>
                           <option>ambulence</option>
                          </select>
-->
             Donation     mask <input type="checkbox" name="donation" value="maks"/>
                         vaccine <input type="checkbox" name="donation" value="vaccine"/>
                         medicine <input type="checkbox" name="donation" value="medicine"/>
            <input type="submit" value="Get-Data"/>
            </pre>
        </form>
        
    </body>
</html>
