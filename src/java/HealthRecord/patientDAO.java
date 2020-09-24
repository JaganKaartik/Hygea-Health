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

/* 
        Patient Information Data Access Object 
        Establish JDBC Connectivity
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.ServletException;


/* Servlet Collaboration (2nd Servlet) to fetch Specific Patient Information */


public class patientDAO extends HttpServlet
{
    /* JDBC Steps */

    /**
     *
     * @param req
     * @param rep
     * @throws SQLException
     */


    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
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


	    try {

	    		/* Testing PrintWriter */

	    		PrintWriter out = rep.getWriter();

                // try {
                //     Class.forName("org.postgresql.Driver");
                // }
                // catch(ClassNotFoundException ex) {
                //     System.out.println(ex);
                // }
                
                /* Fetching Item from previous servlet */
                
                String id = (String) req.getAttribute("id");
                String redirect = (String) req.getAttribute("page");
                
                // String db_url = "jdbc:postgresql://localhost:5432/Electronic_Health_Record";
                // String db_username = "postgres";
                
                String sql = "select * from public.\"PatientInformation\" where pid = '"+id+"' ";

                // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");

                ServletContext ctx=getServletContext();  
                Connection con=(Connection)ctx.getAttribute("mycon");  
                
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                
                //Using POJO (Plain Old Java Object) to Store Information
             
                Patient patient_obj = new Patient();

                
                while(rs.next())
                {
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

                    //patient_obj.setValue(PatientID,First_name,Last_name,DOB,BloodGroup,Address,Pincode,PhoneNumber,MaritalStatus,Age,Sex);
                    	
                    // For De-Bug Purposes

                    out.println(patient_obj.getFirst_name());
                    out.println(patient_obj.getAddress());

               	 	//Pass the Data Back to Reception.JSP

               	    req.setAttribute("pDAO",patient_obj);

                    if(redirect.equals("Reception"))
                    {
                        req.getRequestDispatcher("Reception.jsp").forward(req,rep);
                    }
                    else if(redirect.equals("Admin"))
                    {
                        req.getRequestDispatcher("Admin.jsp").forward(req,rep);
                    }
                    else
                    {
                        req.getRequestDispatcher("Doctor.jsp").forward(req,rep);
                    }
                }   

                if (rs.next() == false) 
                {
                      // rep.sendRedirect("error_page.jsp");
                      req.getRequestDispatcher("error_page.jsp").forward(req,rep);
                 
                }

                /* Closing the Statement and JDBC */

                
                st.close();
                con.close();
               	
            }
	    catch(SQLException ex) {
	        Logger.getLogger(patientDAO.class.getName()).log(Level.SEVERE, null,ex);
	    }
	}


}
