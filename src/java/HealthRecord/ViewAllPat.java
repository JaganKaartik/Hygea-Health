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

    View All Patients Servlet

*/
    
public class ViewAllPat extends HttpServlet 
{
    String PatientID;
    String First_name;
    String Last_name;
    String DOB;
    String BloodGroup;
    String Address;
    String Pincode;
    String PhoneNumber;
    String MaritalStatus;
    String Age;
    String Sex;
    
     public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
     {
            /* Initialize Objects of type Patient */
            
            // Patient[] patient_obj = new Patient[5];
            
            // for(int i=0;i<5;++i)
            // {
            //     patient_obj = new Patient();
            // }

            /* Using ArrayList for Efficiceny */

            try {
                //JDBC Steps
                
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
                String sql = "select * from public.\"PatientInformation\"";
                
                Statement st = con.createStatement();
                
                ResultSet rs = st.executeQuery(sql);

                int i=0;

                List<Patient> patients = new ArrayList<Patient>();

                while(rs.next())
                {
                    Patient patient_obj = new Patient();

                    PatientID = rs.getString(1);
                    patient_obj.setPatientID(PatientID);
                    
                    First_name = rs.getString(2);
                    patient_obj.setFirst_name(First_name);
                    
                    Last_name = rs.getString(3);
                    patient_obj.setLast_name(Last_name);
                    
                    DOB = rs.getString(4);
                    patient_obj.setDOB(DOB);
                    
                    BloodGroup = rs.getString(5);
                    patient_obj.setBloodGroup (BloodGroup);
                    
                    Address = rs.getString(6);
                    patient_obj.setAddress(Address);
                    
                    Pincode = rs.getString(7);
                    patient_obj.setPincode(Pincode);
                    
                    PhoneNumber = rs.getString(8);
                    patient_obj.setPhoneNumber(PhoneNumber);
                    
                    MaritalStatus = rs.getString(9);
                    patient_obj.setMaritalStatus(MaritalStatus);
                    
                    Age = rs.getString(10);
                    patient_obj.setAge(Age);
                    
                    Sex = rs.getString(11);
                    patient_obj.setSex(Sex);

                    patients.add(patient_obj);

                    i = i + 1;
                }

                 //Pass the Data Back (Array List)

                req.setAttribute("pobj",patients);
                req.getRequestDispatcher("Admin.jsp").forward(req,rep);

                //Exception
                
                if(rs.next() == false) 
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
