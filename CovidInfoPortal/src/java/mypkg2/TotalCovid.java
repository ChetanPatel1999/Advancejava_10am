/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg2;

import databaseconnection.Utility;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TotalCovid extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Connection con=Utility.connect();
            String sql="select sum(total) from covidinfo";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            rs.next();
            int total=rs.getInt(1);
            out.print("<h3>Total CovidCase : "+total+"</h3>"); 
            }
         catch (Exception ex) {
            throw new JspException("Error in TotalCovid tag", ex);
        }
    }
    
}
