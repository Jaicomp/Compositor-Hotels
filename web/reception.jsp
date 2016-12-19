<%-- 
    Document   : Reception
    Created on : 19-dic-2016, 11:42:47
    Author     : jaimescript
--%>

<%@page import="hotel.TypeRoom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="marketing.Header"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/reception.css">
        
        <!-- JS -->
        <script src="<%= request.getContextPath() %>/assets/js/ajax.js"></script>
        <script src="<%= request.getContextPath() %>/assets/js/updateNumberOfAvailableRooms.js"></script>
       
        <!-- Beans -->
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        <jsp:useBean id="typeRoomDB" class="database.DBTypeRoom" scope="request" />
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compositor Hotels</title>
        <link rel="icon" type="image/png" sizes="32x32" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-16x16.png">
        <link rel="shortcut icon" type="image/x-icon" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon.ico">
        
        
        <%
            Header header = marketingDB.getHeaderInfoFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            marketingDB.increaseOneVisitOnPage(request.getServletPath().replace("/", ""));

        %>
    </head>
    <body>
        
        <h1> Marketing </h1>
        <div id="listTypeRoom">
            <%
           ArrayList<TypeRoom> typeRooms = typeRoomDB.getTypeRooms();
           for (int i = 0; i < typeRooms.size(); i++) {
                   out.println("<div class=\"RelationHotelTypeRoom\" >");
                   
                   out.println("<div class=\"namePage\" page=\"rooms.jsp\">");
                   out.println("<h1>" + typeRooms.get(i).getNameHotel()+ "</h1>");
                   out.println("</div>");
                   
                   out.println("<div class=\"typeroom\">");
                   out.println("<span>Type of Room: </span>" + typeRooms.get(i).getTypeRoom()+ "");
                   out.println("</div>");
                   
                   out.println("<div class=\"numofavailablerooms\">");
                   out.println("<span>Number of Rooms available: </span><input idRHotelTypeRoom='" + typeRooms.get(i).getIdRHotelTypeRoom() + "' onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"description\" value=\"" + typeRooms.get(i).getNumroomsavailable()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"price\">");
                   out.println("<span>Price: </span>" + typeRooms.get(i).getPrice()+ "");
                   out.println("</div>");
                   
                  
                   
                   out.println("</div>");
               }
            
            
        %>
            
        </div>
        
    </body>
</html>
