/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthRecord;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;

/* Logout-Servlet */

/**
 *
 * @author jagankaartik58
 */
public class LogoutServlet extends HttpServlet
{
     public void doPost(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException 
     {
	      HttpSession session = req.getSession(true);
	      session.removeAttribute("uname");
	      session.invalidate();
	      rep.sendRedirect("index.html");
  	 }
   
}
