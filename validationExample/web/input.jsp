<html>
    <script lang="javascript">
      function checkAll()
      {
          var v1=checkName();
          var v2=checkAge();
          return v1&&v2;
      }
      function checkName()
      {
          var v1=document.getElementById("t1").value;
          var v2=v1.length;
          if(v2==0)
          {
              alert("name cant be blank");
              return false;
          }
          else
          {
             return true; 
          }
      }
      function checkAge()
      {
        var v1=document.getElementById("t2").value;  
        if(isNaN(v1)==true)
        {
            alert("please given number only");
            return false;
        }
        else
        {
          return true;  
        }
      }
    </script> 
    <body>
        <h1>Validation-Example</h1>
        <h3>Data-Entry-Form</h3>
        <form action="Processdata" onsubmit="return checkAll()">
            <pre>
             Name :<input type="text" id="t1" name="t1"/>
             Age  :<input type="text" id="t2" name="t2"/>
                  <input type="submit" value="Submit"/>
            </pre>
        </form>
        
    </body>
</html>
