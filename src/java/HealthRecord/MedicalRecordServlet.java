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

/* Servlet to Add Medical Records to Database */

import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

public class MedicalRecordServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
	{

            
        try {
            PrintWriter out = rep.getWriter();
            
            String PatientID = req.getParameter("pid");
            
            String Allergies = req.getParameter("Allergies");
            String Medications = req.getParameter("Medications");
            String Problems = req.getParameter("Problems");
            String Vaccinations = req.getParameter("Vaccinations");
            
            String Height = req.getParameter("Height");
            String Weight = req.getParameter("Weight");
            String BodyTemp = req.getParameter("BodyTemp");
            String PulseRate = req.getParameter("PulseRate");
            String BPDiastolic = req.getParameter("BPDiastolic");
            String BPSystolic = req.getParameter("BPSystolic");
            
            String PrevConsultation = req.getParameter("PrevConsultation");
            String Habits = req.getParameter("Habits");
            String SurgeryHistory = req.getParameter("SurgeryHistory");
            
            
            /* Testing Purposes to verify client-->servlet data integrity */
            
            out.println(PatientID);
            out.println(Allergies);
            out.println(Medications);
            out.println(Problems);
            out.println(Vaccinations);
            out.println(Height);
            out.println(Weight);
            out.println(BodyTemp);
            out.println(PulseRate);
            out.println(BPDiastolic);
            out.println(BPSystolic);
            out.println(PrevConsultation);
            out.println(Habits);
            out.println(SurgeryHistory);
            
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

            /* Using Servlet Context Listener insted of Traditional JDBC Steps */

            ServletContext ctx=getServletContext();  
            Connection con=(Connection)ctx.getAttribute("mycon"); 

            PreparedStatement ps = con.prepareStatement("insert into public.\"MedicalRecords\" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            
            
            ps.setString(1,PatientID);
            ps.setString(2,Allergies);
            ps.setString(3,Medications);
            ps.setString(4,Problems);
            ps.setString(5,Vaccinations);
            ps.setString(6,Height);
            ps.setString(7,Weight);
            ps.setString(8,BodyTemp);
            ps.setString(9,PulseRate);
            ps.setString(10,BPDiastolic);
            ps.setString(11,BPSystolic);
            ps.setString(12,PrevConsultation);
            ps.setString(13,Habits);
            ps.setString(14,SurgeryHistory);

            int val = ps.executeUpdate();

            rep.sendRedirect("Reception.jsp");

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
                
            ps.close();
            con.close();
   
        }
        catch(SQLException ex) {
                Logger.getLogger(MedicalRecordServlet.class.getName()).log(Level.SEVERE, null,ex);
        }
	}
}
