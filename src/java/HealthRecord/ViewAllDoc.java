/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthRecord;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jagankaartik58
 */

/*

    View All Doctors Servlet

*/

public class ViewAllDoc extends HttpServlet
{
	String EID;
    String Name;
    String Gender;
    String Education;
    String Speciality;
   	String Certifications;    


   	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
   	{
        try {
            // Doctor[] doctor_obj = new Doctor[5];
            
            //       for(int i=0;i<5;++i)
            //       {
            //           doctor_obj[i] = new Doctor();
            //       }

            //JDBC Steps to retrive All Doctors
            
            PrintWriter out = rep.getWriter();
            
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
            String sql = "select * from public.\"Doctor\"";
            
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);

            
            int i=0;
            
            List<Doctor> doctor = new ArrayList<Doctor>();
            
            while(rs.next())
            {
                Doctor doctor_obj = new Doctor();
                
                EID = rs.getString(1);
                doctor_obj.setEID(EID);
                
                Name = rs.getString(2);
                doctor_obj.setName(Name);
                
                Gender = rs.getString(3);
                doctor_obj.setGender(Gender);
                
                Education = rs.getString(4);
                doctor_obj.setEducation(Education);
                
                Speciality = rs.getString(5);
                doctor_obj.setSpeciality(Speciality);
                
                Certifications = rs.getString(6);
                doctor_obj.setCerfitications(Certifications);
                
                doctor.add(doctor_obj);
            }

            req.setAttribute("doctors",doctor);
            req.getRequestDispatcher("Admin.jsp").forward(req,rep);

            if (rs.next() == false) 
            {
                  
                  rep.sendRedirect("error_page.jsp");
             
            }

            /* Close Statement and Connection in JDBC */
                
            st.close();
            con.close();
            
        }
        catch(SQLException ex) {
        	System.out.println(ex);
        }

   	}

}
