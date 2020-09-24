/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 

References 

JDBC Prepared Statement : https://www.studytonight.com/servlet/registration-form-example-in-servlet.php

*/



/* Signup Servlet is working */




package HealthRecord;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.ServletException;



/**
 *
 * @author jagankaartik58
 */



public class SignupServlet extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
    {
             PrintWriter out = rep.getWriter();
            try {
                String id = req.getParameter("id");
                String username = req.getParameter("user");
                String password = req.getParameter("p1");
                String role = req.getParameter("role");

                // String db_url = "jdbc:postgresql://localhost:5432/Electronic_Health_Record";
                // String db_username = "postgres";
                // try {
                //     Class.forName("org.postgresql.Driver");
                // }
                // catch (ClassNotFoundException ex) 
                // {
                //     Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                // }
                // Connection conn = DriverManager.getConnection(db_url,db_username,"qpalzmwer");


                ServletContext ctx=getServletContext();  
                Connection con=(Connection)ctx.getAttribute("mycon");

                PreparedStatement ps = con.prepareStatement("insert into public.\"User\" values(?,?,?,?)");

                ps.setString(1, id);
                ps.setString(2, username);
                ps.setString(3, role);
                ps.setString(4, password);

                
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
                
                // Redirect to Admin.jsp page

                    req.getRequestDispatcher("Admin.jsp").forward(req,rep);

                /* Close Statement and Connection in JDBC */
                
                ps.close();
                con.close();
            }
            catch (SQLException ex) 
                {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
