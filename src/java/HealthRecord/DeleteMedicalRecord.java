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

// Status: Verified

/* Servlet to Delete Medical Records from the Database */

import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

public class DeleteMedicalRecord extends HttpServlet
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
              // String sql = "delete from public.\"PatientInformation\" where pid = '"+id+"' ";
              
              // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");

              /* Fetching Id of Patient whose record is to be deleted from Reception.JSP atm */
              
              String id = req.getParameter("id");
              String redirect = req.getParameter("page");


              ServletContext ctx=getServletContext();  
              Connection con=(Connection)ctx.getAttribute("mycon");


              String sql = "delete from public.\"MedicalRecords\" where patientid = '"+id+"' ";

              String newsql = "update public.\"MedicalRecords\" ";
              
              Statement st = con.createStatement();

              out.println(sql);
              
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

              /* Redirect to Reception.JSP or Admin.JSP */


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
