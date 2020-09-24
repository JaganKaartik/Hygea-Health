/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthRecord;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

/**
 *
 * @author jagankaartik58
 */

/*  
    Testing Servlet (29-Sept-2019)
*/

public class patientServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
    {
        String pid = req.getParameter("pid");
        String pname = req.getParameter("pname");
        String pdob = req.getParameter("pdob");
        String pno = req.getParameter("pno");
        String pms = req.getParameter("pms");
        String pbg = req.getParameter("pbg");
        String pad = req.getParameter("pad");
        
        Patient p = new Patient();
        //p.setValue(pname,pid,pdob,pbg,pad,pno,pms);
                
        /* Servlet is Working */
        PrintWriter out = rep.getWriter();
        out.println("Pid is : "+pid);
        out.println("Pname is : "+pname);
        
    }
}
