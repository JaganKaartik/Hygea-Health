<%-- 
    Document   : error
    Created on : Oct 8, 2019, 11:45:48 PM
    Author     : jagankaartik58
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>404 Not Found</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,700" rel="stylesheet">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css" />

        <link type="text/css" rel="stylesheet" href="css/error.css" />

    </head>
<body>

    <div id="notfound">
        <div class="notfound">
            <div class="notfound-404">
                <h1>Oops!</h1>
                <h2>404 - The Page can't be found</h2>
            </div>
            <a href="index.html">Go TO Homepage</a>
            <%
                session.invalidate();
            %>
        </div>
    </div>

</body>

</html>
