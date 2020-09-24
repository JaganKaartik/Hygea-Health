<%-- 
    Document   : Doctor
    Created on : Sep 30, 2019, 4:55:14 AM
    Author     : jagankaartik58
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="HealthRecord.MedicalRecord"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="HealthRecord.Patient"%>
<%@page import="HealthRecord.Doctor"%>

<!-- Exception Handling Page -->

<%@ page errorPage="exception.jsp" %> 

<!-- End of Exception Handling Page Import -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

        <!-- JQuery -->
        
        <script src=' https://code.jquery.com/jquery-3.4.1.min.js'></script>

        <!-- Custom CSS -->
        
        <link rel="stylesheet" href="css/base.css" type="text/css">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

         <!-- External JavaScript File -->
        
        <script src="js/home.js"></script>

        <!-- Google Fonts -->

        <link href='https://fonts.googleapis.com/css?family=Actor' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Esteban' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>


        <style type="text/css">
            
            .jagmod{
                font-family: 'Actor';font-size: 22px;
            }

            .jagmod2{
                font-family: 'Esteban';font-size: 22px;
            }
            .jagcust{
                  font-family: 'Noto Sans';font-size: 22px;
            }
            .nav-wrapper{
                background-color: #3ab5a5;
            }
        </style>

        <title>Doctor JSP</title>

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
            <div class="nav-wrapper cyan darken-3 ">
                <!-- HREF TO ABOUT.HTML -->
                <a href="#" class="brand-logo right">HygeaHealth+</a>
                <a href="#" class="brand-logo center">Doctor Dashboard</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                <form action="logout" method="post">
                    <button type="submit" class="btn btn-primary">LogOut</button>
                </form>
                </li>
                </ul>
            </div>
        </nav>


        <!-- 

                Doctor Schema

                String EID;
                String Name;
                String Gender;
                String Education;
                String Speciality;
                String Certifications;

                Patient Schema

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
                

                    Doctor <TREATS> Patients

                 Doctor X  -> Treats Patient(s) Y..

                        Medical Records

                                
                                <TREATS>

                EID Name Speciality PatientID (Medical History)









         -->

         <div class="container">
            <%
                
                String username = (String)session.getAttribute("uname");  
                String role = (String)session.getAttribute("role");  

            %>
                 <h4 class="center-align cyan-text text-darken-3">Welcome! Dr. <%=username%></h4> 
            
        </div>

         <div class="container">
                
               
            
            <div class="card-panel hoverable cyan darken-3 row ">
                <!-- Row 2 -->
                <div class="row">
                <h5 class="jagcust cyan-text text-lighten-3">Search Patient Demographics</h5>
                </div>
                    <nav>
                        <div class="nav-wrapper">

                        <form method="get" action="patinfocontrol">
                            <div class="input-field">
                              <input name="ser" type="search" placeholder="Patient ID" required>
                              <input type="hidden" name="page" value="Doctor">
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
                            out.println("<table class=\"cyan-text text-lighten-3 centered highlight\">");
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

            <div class="card-panel hoverable cyan lighten-3 row">

                 <div class="row">
                 <h5 class="cyan-text text-darken-4">Search Patient Medical Records</h5>
                 </div>
                 
                 <nav>
                        <div class="nav-wrapper">
                            <form method="get" action="viewmedrec">
                                <div class="input-field">
                                  <input name="recordid" type="search" placeholder="Patient ID" required>
                                  <input type="hidden" name="page" value="Doctor">
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

                            out.println("<br>");
                            out.println("<br>");

                            /* First Table */
                            out.println("<div class=\"row\">");

                            out.println("<h5 class=\"center-align cyan-text text-darken-4  jagmod\">Medical Profile</h5>");

                            out.println("</div>");

                            out.println("<table class=\"cyan-text text-darken-4 centered highlight\">");

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

                            out.println("<h5 class=\"center-align cyan-text text-darken-4 jagmod\">Vitals</h5>");

                            out.println("</div>");

                            /* Start of Table 2 */

                            out.println("<table class=\"cyan-text text-darken-4 centered highlight\">");

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

                            out.println("<h5 class=\"center-align cyan-text text-darken-4 jagmod\">Medical History</h5>");

                            out.println("</div>");

                            /* Start of Table 3 */

                            out.println("<table class=\"cyan-text text-darken-4 centered highlight\">");

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

             <!-- Row 2 -->
                <h5 class="cyan-text text-darken-3">Update Personal Information</h5>
               <button type="button" class="btn btn-primary" id="infoButton">Toggle to View Form</button>

            <div class="card-panel hoverable cyan darken-3 row">
                    <form id="form1" class="col s6" method="post" action="adddoc">

                         <div class = "row">
                               <div class="input-field col s6">
                                  <input name="EID" type="text" class="validate">
                                  <label for="EID">EID</label>
                               </div>
                         </div>

                         <div class="row">
                                <div class="input-field col s6">
                                  <input name="Name" type="text" class="validate">
                                  <label for="Name">Name</label>
                                </div>
                         </div>

                         <div class="row">
                                <div class="input-field col s6">
                                  <input name="Gender" type="text" class="validate">
                                  <label for="Gender">Gender</label>
                                </div>
                         </div>

                         <div class = "row">
                               <div class="input-field col s6">
                                  <input name="Education" type="text" class="validate">
                                  <label for="Education">Education</label>
                               </div>
                         </div>

                         <div class="row">
                                <div class="input-field col s6">
                                  <input name="Speciality" type="text" class="validate">
                                  <label for="Speciality">Speciality</label>
                                </div>
                         </div>

                         <div class="row">
                                <div class="input-field col s6">
                                  <input name="Certifications" type="text" class="validate">
                                  <label for="Certifications">Certifications</label>
                                </div>
                         </div>
                        
                         <button class="btn btn-primary" >Update</button>
                    </form>
                
                          

            </div>

          <button type="button" class="btn btn-primary" id="info2Button">Toggle to View Servlet Information</button>
            <div class="card-panel hoverable cyan darken-3 row">
                    <form id="form2">
                     <%
                      
                         String abspath = application.getServerInfo();

                     %>
                     <div class = "row">
                        <h5 class="jagmod2 cyan-text text-lighten-3">Server Information: <%= abspath%></h5>
                    <h5 class="jagmod2 cyan-text text-lighten-3">ServletContext (Real Path) :<%=getServletContext().getRealPath("/")%></h5>
                    </div>
                    </form>
            </div>

         </div>
                 

        <script type="text/javascript">
            $("#infoButton").click(function(){$("#form1").toggle();});
            $("#info2Button").click(function(){$("#form2").toggle();});
        </script>
    </body>
</html>
