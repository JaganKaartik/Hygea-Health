<%-- 
    Document   : Reception
    Created on : Oct 6, 2019, 12:38:14 PM
    Author     : jagankaartik58
--%>

<%@page import="HealthRecord.MedicalRecord"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="HealthRecord.Patient"%>
<%@page import="HealthRecord.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Exception Handling Page -->

<%@ page errorPage="exception.jsp" %> 

<!-- End of Exception Handling Page Import -->


<!DOCTYPE html>

<!-- 
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 -->

<!-- Reception.JSP Page Complete -->

<html>
    <head>
        <title>Reception</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- BootStrap Framework -->

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js" ></script>

        <!-- Materialize Front End Framework -->

        <!-- Compiled and minified CSS -->

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">          

        <!-- Compiled and minified JavaScript -->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script> 

        <!-- Custom CSS -->

        <link rel="stylesheet" href="css/base.css" type="text/css">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=EB Garamond' rel='stylesheet'>

        <style type="text/css">
            
            body {
                font-family: 'EB Garamond';font-size: 22px;
            }
            .customcont {
              width: 85%;
              margin: auto;
            }
            .nav-wrapper{
                background-color: #3ab5a5;
            }

        </style>

    </head>

    <body>

        <!-- CHECK IF USER IS LOGGIN IN OR NOt USING SESSION TRACKING -->

        <%

            if(session.getAttribute("uname")==null)
            {
                response.sendRedirect("index.html");
            }

        %>

		 <nav>
		    <div class="nav-wrapper cyan darken-3">
		    	<!-- HREF TO ABOUT.HTML -->
			    <a href="#" class="brand-logo right">HygeaHealth+</a>
			    <a href="#" class="brand-logo center">Reception Dashboard</a>
			    <ul id="nav-mobile" class="left hide-on-med-and-down">
		          <li><a href="registerpatient.html">Register Patient</a></li>
                  <li><a href="AddMedicalRecord.html">Add Medical Record</a></li>
                <li>
		        <form action="logout" method="post">
                    <button type="submit" class="btn btn-primary">LogOut</button>
                </form>
                </li>
		     	</ul>
		    </div>
  		</nav>

        <div class="customcont">

            <div class="card-panel hoverable cyan lighten-4 row">

                <!-- Row 1 -->

                 <%
                    // TO DISPLAY USER AND ROLE
                    
                    String username = (String)session.getAttribute("uname");  
                    String role = (String)session.getAttribute("role");  

                %>

            <h5 class="cyan-text text-darken-3 row">Hello! <%=role%> <%=username%></h5>

            </div>

            <div class="card-panel hoverable cyan darken-3  ">
                <!-- Row 2 -->
                    <h5 class="white-text">View Patient Details</h5>
                    <nav>
                        <div class="nav-wrapper">

                        <form method="get" action="patinfocontrol">
                            <div class="input-field">
                              <input name="ser" type="search" placeholder="Patient ID" required>
                              <input type="hidden" name="page" value="Reception">
                              <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                              <i class="material-icons">close</i>
                            </div>
                        </form>
                        </div>
                    </nav>


                    <!-- Output Dynamic Data from Patient Information Control -->

                    <%

                        if(request.getAttribute("pDAO")!=null)
                        {

                            Patient patient_obj = (Patient)request.getAttribute("pDAO");

                            out.println("<br>");
                            out.println("<br>");
                            out.println("<table class=\"cyan-text text-lighten-4 centered highlight\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<th>Patient ID</th>");
                            out.println("<th>First Name</th>");
                            out.println("<th>Last Name</th>");
                            out.println("<th>Date of Birth</th>");
                            out.println("<th>Blood Group</th>");
                            out.println("<th>Address</th>");
                            out.println("<th>Pincode</th>");
                            out.println("<th>Phone Number</th>");
                            out.println("<th>Marital Status</th>");
                            out.println("<th>Age</th>");
                            out.println("<th>Sex</th>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("<tbody>");
                            out.println("<tr>");
                                out.println("<td>");
                                out.println(patient_obj.getPatientID());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getFirst_name());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getLast_name());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getDOB());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getBloodGroup());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getAddress());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getPincode());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getPhoneNumber());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getMaritalStatus());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getAge());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(patient_obj.getSex());
                                out.println("</td>");
                            out.println("</tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    %>

            </div>

            <div class="card-panel hoverable cyan lighten-4 row">
                 <h5 class="cyan-text text-darken-3">View Doctor Details</h5>
                 <nav>
                        <div class="nav-wrapper">
                            <form method="get" action="viewdoc">
                                <div class="input-field">
                                  <input name="id" type="search" placeholder="ID" required>
                                  <input type="hidden" name="page" value="Reception">
                                  <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                  <i class="material-icons">close</i>
                                </div>
                            </form>
                        </div>
                </nav>

                <!-- Output Dynamic Data from Doctor Details Servlet -->

                <%
                    if(request.getAttribute("doctor")!=null)
                    {
                            
                            
                            /* Doctor Servlet Returns Doctor Object */

                            Doctor d = (Doctor)request.getAttribute("doctor");

                            out.println("<br>");
                            out.println("<br>");
                            out.println("<table class=\"centered highlight cyan-text text-darken-4\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<th>Doctor ID</th>");
                            out.println("<th>Name</th>");
                            out.println("<th>Gender</th>");
                            out.println("<th>Education</th>");
                            out.println("<th>Speciality</th>");
                            out.println("<th>Certifications</th>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("<tbody>");
                            out.println("<tr>");
                                out.println("<td>");
                                out.println(d.getEID());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(d.getName());
                                out.println("</td>");   
                                out.println("<td>");
                                out.println(d.getGender());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(d.getEducation());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(d.getSpeciality());
                                out.println("</td>");
                                out.println("<td>");
                                out.println(d.getCertifications());
                                out.println("</td>");
                            out.println("</tr>");
                            out.println("</tbody>");
                            out.println("</table>");

                    }
                %>

            </div>

            <div class="card-panel hoverable cyan darken-3 row">
                 <h5 class="white-text">View Patient Medical Records</h5>
                 <nav>
                        <div class="nav-wrapper">
                            <form method="get" action="viewmedrec">
                                <div class="input-field">
                                  <input name="recordid" type="search" placeholder="Patient ID" required>
                                  <input type="hidden" name="page" value="Reception">
                                  <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                  <i class="material-icons">close</i>
                                </div>
                            </form>
                        </div>
                </nav>
                <!-- View Medical Record Details-->

                <!-- Output Dynamic Data from Medical Records Servlet -->

               <%
                    if(request.getAttribute("medicalrecord")!=null)
                    {
                            /* Medical Records Servlet o/pts data */

                            MedicalRecord mr = (MedicalRecord)request.getAttribute("medicalrecord");

                            /* Testing JSP Implicit Error Handling Object */

                            /* Checking all vitals is not NULL/NIL */

                            if(mr.getHeight().length()==0)
                            {
                                throw new Exception("Vitals not found");
                            }

                            out.println("<br>");
                            out.println("<br>");

                            /* First Table */
                            out.println("<div class=\"row\">");

                            out.println("<h5 class=\"center-align cyan-text text-lighten-1 jagmod\">Medical Profile</h5>");

                            out.println("</div>");

                            out.println("<table class=\"cyan-text text-lighten-4 centered highlight\">");

                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<th>Patient ID</th>");
                            out.println("<th>Allergies</th>");
                            out.println("<th>Medications</th>");
                            out.println("<th>Problems</th>");
                            out.println("<th>Vaccinations</th>");
                            out.println("</tr>");
                            out.println("</thead>");

                            out.println("<tbody>");

                            out.println("<tr>"); //fist row

                                out.println("<td>");
                                out.println(mr.getPatientID());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getAllergies());
                                out.println("</td>");  

                                out.println("<td>");
                                out.println(mr.getMedications());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getProblems());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getVaccinations());
                                out.println("</td>");

                            out.println("</tr>"); //end of first row


                            /* new Mod */

                            out.println("</tbody>");

                            out.println("</table>");

                            /* END OF TABLE 1 */

                            out.println("<div class=\"row\">");

                            out.println("<h5 class=\"center-align cyan-text text-lighten-1 jagmod\">Vitals</h5>");

                            out.println("</div>");

                            /* Start of Table 2 */

                            out.println("<table class=\"cyan-text text-lighten-4 centered highlight\">");

                            /* New Mod */

                            out.println("<thead>");

                            out.println("<tr>");
                            
                            out.println("<th>Height</th>");
                            out.println("<th>Weight</th>");
                            out.println("<th>Body Temp</th>");
                            out.println("<th>PulseRate</th>");
                            out.println("<th>BPDiastolic</th>");
                            out.println("<th>BPSystolic</th>");

                            out.println("</tr>");

                            out.println("</thead>");

                            /* MOD */

                            out.println("<tbody>");

                            out.println("<tr>"); //second data row

                                out.println("<td>");
                                out.println(mr.getHeight());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getWeight());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getBodyTemp());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getPulseRate());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getBPDiastolic());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getBPSystolic());
                                out.println("</td>");


                            out.println("</tr>"); //end of second data row

                             /* new Mod */

                            out.println("</tbody>");

                            out.println("</table>");

                            /* END OF TABLE 2 */

                            out.println("<div class=\"row\">");

                            out.println("<h5 class=\"center-align cyan-text text-lighten-1 jagmod\">Medical History</h5>");

                            out.println("</div>");

                            /* Start of Table 3 */

                            out.println("<table class=\"cyan-text text-lighten-4 centered highlight\">");

                            out.println("<thead>");

                            out.println("<tr>");
                            
                            out.println("<th>PrevConsultation</th>");
                            out.println("<th>Habits</th>");
                            out.println("<th>SurgeryHistory</th>");
                     

                            out.println("</tr>");
                            out.println("</thead>");

                            out.println("<tbody>");

                            out.println("<tr>"); //third data row

                                out.println("<td>");
                                out.println(mr.getPrevConsultation());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getHabits());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(mr.getSurgeryHistory());
                                out.println("</td>");

                            out.println("</tr>"); //end of third data row

                            out.println("</tbody>");

                            out.println("</table>");

                    }
                %>

            </div>

            <div class="card-panel  hoverable cyan lighten-4 row">
                <h5 class="cyan-text text-darken-3">Delete Patient</h5>
                <nav>
                        <div class="nav-wrapper">
                            <form method="post" action="delpat">
                                <div class="input-field">
                                  <input name="id" type="search" placeholder="Patient ID" required>
                                  <input type="hidden" name="page" value="Reception">
                                  <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                  <i class="material-icons">close</i>
                                </div>
                            </form>
                        </div>
                </nav>
            </div>

             <!-- TESTED JSP IMPLICIT ERROR OBJECT -->

             <!-- TO REMOVE THE ERROR RECORD -->

             <div class="card-panel  hoverable cyan darken-3 row">
                <h5 class="white-text">Delete Medical Record</h5>
                <nav>
                        <div class="nav-wrapper">
                            <form method="post" action="delmedrec">
                                <div class="input-field">
                                  <input name="id" type="search" placeholder="Patient ID" required>
                                  <input type="hidden" name="page" value="Reception">
                                  <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                  <i class="material-icons">close</i>
                                </div>
                            </form>
                        </div>
                </nav>
            </div>

        </div>
    </body>
</html>
