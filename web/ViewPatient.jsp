<%-- 
    Document   : Reception
    Created on : Sep 30, 2019, 4:49:14 PM
    Author     : jagankaartik58
--%>


<!-- Dynamic Web Page for Viewing Patient Information--->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- BootStrap -->

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js" ></script>

        <!-- Materialize -->

        <!-- Compiled and minified CSS -->

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">         

        <!-- Compiled and minified JavaScript -->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script> 

        <!-- Custom CSS Stylesheets -->

        <link rel="stylesheet" href="css/base.css" type="text/css">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


        <title>Patient List</title>
        
    </head>
    <body>
         <nav>
		    <div class="nav-wrapper light-blue darken-3">

		        <!-- HREF TO ABOUT.HTML -->

			<a href="#" class="brand-logo right">HygeaHealth+</a>
			<h6 class="brand-logo center">Patient Information</h6>

                 <!-- Nav Bar (View Patient) -->
		    </div>
        </nav>

            <!-- Need to implement SERVLET -- SERVLET Connection  -->

               <!--  <h6 class="white-text center">
                    This to do: <br><br>
                        1. VieW All Patient Records <br><br>
                        2. Add Any Medical History (Sep Table) <br><br>
                        <br>
                </h6>
 -->
                <!-- Search Bar -->

                 <div class="container">

                    <div class="row">
                        <h4>View Patient Record</h4>
                    </div>
                    
                    <nav>
                        <div class="nav-wrapper">

                            <!-- Patient Info Controller -->

                          <form method="get" action="patinfocontrol">
                            <div class="input-field">
                              <input name="ser" type="search" placeholder="Patient ID" required>
                              <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                              <i class="material-icons">close</i>
                            </div>
                          </form>

                        </div>
                      </nav>

                    <br>
                    <br>
                
                 </div>               

                <!-- UI/UX  -->

                <!-- 

                        Split view into three columns basically

                        col1 = 2
                        col2 = 5
                        col3 = 5
            
                 -->

                 <!-- UI Test -->
            <!-- <div class="row">

            <div class="col s2">

                <h1 class="white-text">Testing Column 1</h1>

            </div>

            <div class="col s5">

                <h1 class="white-text">Testing Column 2</h1>

            </div>

            <div class="col s5">

                <h1 class="white-text">Testing Column 3</h1>

            </div>

            </div> -->

    </body>
</html>
