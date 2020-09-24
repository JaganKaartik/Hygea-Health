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
**
** 		SERVLET COLLABORATION IS IMPLEMENTED HERE
**
*/


/*

	Controller: To View Patient Information

	View Patient.JSP --> Calls PatientInfoController.java

*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.servlet.ServletException;

public class PatientInfoController extends HttpServlet
{
    
    /*  

        Servlet 1 to accept a request from client!
        Servlet 1 forwards the request to Servlet 2
        Servlet - Servlet Collaboration

     */

    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
    {
        // Accept Search Query for Patient ID or name

        String search_query = req.getParameter("ser");
        String page = req.getParameter("page");

        // Setting the attribute of request object so that it can be accessed in the forwarded servlet

       	req.setAttribute("id",search_query);
        req.setAttribute("page",page);

        // Redirecting client request to another Servlet

        RequestDispatcher rd = req.getRequestDispatcher("patientDAO"); 
        rd.forward(req,rep);

    }
}
