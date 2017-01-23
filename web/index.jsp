<%-- 
    Document   : index
    Created on : 13-nov-2016, 13:41:49
    Author     : jaimescript
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Title and main Icon -->
        <title>Compositor Hotels</title>
        <link rel="icon" type="image/png" sizes="32x32" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-16x16.png">
        <link rel="shortcut icon" type="image/x-icon" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon.ico">
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/landing.css">
        
        <!-- CDN -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        
        <!-- JS -->
        <script src="<%= request.getContextPath() %>/assets/js/index/main.js"></script>
    
    </head>
    <body>
        <header>
        <img src="<%= request.getContextPath() %>/assets/images/logo.png" width="100" height="100" />
        
        <ul>
            <li class="active" ><a href="#home" class="tooltip">•<span class="tooltiptext">Home</span></a></li>
            <li><a href="#about" class="tooltip">•<span class="tooltiptext">About</span></a></li>
            <li><a href="#" class="tooltip">•<span class="tooltiptext">Rooms</span></a></li>
            <li><a href="#" class="tooltip">•<span class="tooltiptext">Services</span></a></li>
            <li><a href="#" class="tooltip">•<span class="tooltiptext">Location</span></a></li>
        </ul>
        
        </header>
        
        <div id="content">
            <div id="home">
              <img id="mainImage" src="<%= request.getContextPath() %>/assets/images/hotel.jpg" width="100" height="100"/>
              <div id="backgroundFilter"></div>
              <h1><hr>Compositor Hotels<br><hr></h1>
              <h2>IN MAJORCA</h2>
              <a href="rooms.jsp">MAKE A RESERVATION</a>
              
            </div>
              <!--
            <div id="about">
                
                jajajajaj
            </div>
              -->
        </div>
    </body>
</html>
