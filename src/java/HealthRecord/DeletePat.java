/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthRecord;

/**
 *
 * @author jagankaartik58
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.ServletException;


public class DeletePat extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
    {
    	PrintWriter out = rep.getWriter();  
        try{
              
              // try{
              //     Class.forName("org.postgresql.Driver");
              // }
              // catch(ClassNotFoundException ex) {
              //     System.out.println(ex);
              // }
            
              
              // String db_url = "jdbc:postgresql://localhost:5432/Electronic_Health_Record";
              // String db_username = "postgres";
              
              // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");

              /* Fetching Id from Reception.JSP */
              
              String id = req.getParameter("id");
              String redirect = req.getParameter("page");

              String sql = "delete from public.\"PatientInformation\" where pid = '"+id+"' ";


              ServletContext ctx=getServletContext();  
              Connection con=(Connection)ctx.getAttribute("mycon");
              
              Statement st = con.createStatement();

              
              int val = st.executeUpdate(sql);
              
              if(val>0)
              {
                  out.println("Success!");
                  //Success
              }
              else
              {
                  out.println("Failed!");
                  //fail
              }
              
              /* Close Statement and Connection in JDBC */

              st.close();
              con.close();

              /* Forward! Re-Direct to Reception.JSP or Admin.JSP */

              if(redirect.equals("Reception"))
              {
                 rep.sendRedirect("Reception.jsp");
              }
              else
              {
                 rep.sendRedirect("Admin.jsp");
              }      
          }
             catch(SQLException ex) {
                 Logger.getLogger(DeletePat.class.getName()).log(Level.SEVERE, null,ex);
             }

    }    
}
