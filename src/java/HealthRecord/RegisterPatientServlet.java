/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Writing Patient Data to DB Class */

/* Register Patient Servlet is Working */

package HealthRecord;

import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;

/**
 *
 * @author jagankaartik58
 */

public class RegisterPatientServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
    {
        PrintWriter out = rep.getWriter();
   
        try {
            
            //Form object to RegisterPatient Servelt --> JDBC
            
            String pid 			= req.getParameter("pid"); 			  //Patient ID
            String first_Name 	= req.getParameter("first_Name"); 	  //First Name
            String last_Name	= req.getParameter("last_Name"); 	  //Last Name
            String dob 			= req.getParameter("dob"); 			  //Patient DOB
            String age 			= req.getParameter("age"); 			  //Patient Age
            String sex 			= req.getParameter("sex"); 			  //Patient Sex
            String address 		= req.getParameter("address"); 		  //Patient Address
            String pincode 		= req.getParameter("pincode"); 		  //Patient Pincode
            String bloodgroup 	= req.getParameter("bloodgroup"); 	  //Patient Bloodgroup
            String pno			= req.getParameter("pno"); 			  //Patient Phone Number
            String marstat 		= req.getParameter("marital_status"); //Patient Marital Status
            
            out.println(pid);
            out.println(first_Name);
            out.println(last_Name);
            out.println(dob);
            out.println(age);
            out.println(sex);
            out.println(address);
            out.println(pincode);
            out.println(bloodgroup);
            out.println(pno);
            out.println(marstat);

            /* JDBC Steps */
            
           //  try {
           //      Class.forName("org.postgresql.Driver");
           //  }
           //  catch(ClassNotFoundException ex) {
           //      System.out.println(ex);
           //  }
            
           //  String db_url = "jdbc:postgresql://localhost:5432/Electronic_Health_Record";
           //  String db_username = "postgres";
            
           // // String sql = "select * from public.\"User\" ";
            
            // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");

            /* Using DB Listerner instead of writing all JDBC Steps */

            ServletContext ctx=getServletContext();  
            Connection con=(Connection)ctx.getAttribute("mycon");  

            PreparedStatement ps = con.prepareStatement("insert into public.\"PatientInformation\" values (?,?,?,?,?,?,?,?,?,?,?);");
            
            /* Setting the PreparedStatements */
            
            ps.setString(1,pid);
            ps.setString(2,first_Name);
            ps.setString(3,last_Name);
            ps.setString(4,dob);
            ps.setString(5,bloodgroup);
            ps.setString(6,address);
            ps.setString(7,pincode);
            ps.setString(8,pno);
            ps.setString(9,marstat);
            ps.setString(10,age);
            ps.setString(11,sex);

            out.println(ps);

            int val = ps.executeUpdate();


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

            req.getRequestDispatcher("Reception.jsp").forward(req,rep);

            /* Close Statement and Connection in JDBC */
                
            ps.close();
            con.close();
        }
        catch(SQLException ex) {
                System.out.println(ex);
        }
    }		
}
