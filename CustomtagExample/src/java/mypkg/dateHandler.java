package mypkg;
import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class dateHandler extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
           Date dt=new Date();
           String str=dt.toString();
           out.print("<h3>"+str+"</h3>");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
