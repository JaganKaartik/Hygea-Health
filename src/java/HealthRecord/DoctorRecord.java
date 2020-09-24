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

import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

public class DoctorRecord extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
	{

            
            try {
                PrintWriter out = rep.getWriter();
                
                String EID = req.getParameter("EID");
                String Name = req.getParameter("Name");
                String Gender = req.getParameter("Gender");
                String Education = req.getParameter("Education");
                String Speciality = req.getParameter("Speciality");
                String Certifications = req.getParameter("Certifications");
                
                /* JDBC Steps */
                
                // try {
                //     Class.forName("org.postgresql.Driver");
                // }
                // catch(ClassNotFoundException ex) {
                //     System.out.println(ex);
                // }
                
                // String db_url = "jdbc:postgresql://localhost:5432/Electronic_Health_Record";
                // String db_username = "postgres";
                // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");

                ServletContext ctx=getServletContext();  
                Connection con=(Connection)ctx.getAttribute("mycon");

                PreparedStatement ps = con.prepareStatement("insert into public.\"Doctor\" values (?,?,?,?,?,?);");
                
                
                ps.setString(1,EID);
                ps.setString(2,Name);
                ps.setString(3,Gender);
                ps.setString(4,Education);
                ps.setString(5,Speciality);
                ps.setString(6,Certifications);
                
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
                
                req.getRequestDispatcher("Doctor.jsp").forward(req,rep);
                
                /* Close Statement and Connection in JDBC */
                
                ps.close();
                con.close();
                
            }
            catch(SQLException ex) {
                Logger.getLogger(DoctorRecord.class.getName()).log(Level.SEVERE, null,ex);
            }
   
	}
}
