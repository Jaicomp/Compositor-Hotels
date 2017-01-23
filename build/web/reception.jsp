<%-- 
    Document   : Reception
    Created on : 19-dic-2016, 11:42:47
    Author     : jaimescript
--%>

<%@page import="hotel.Booking"%>
<%@page import="hotel.TypeRoom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="marketing.Header"%>
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
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/modal.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/reception.css">
        
        <!-- JS -->
        <script src="<%= request.getContextPath() %>/assets/js/ajax.js"></script>
        <script src="<%= request.getContextPath() %>/assets/js/updateNumberOfAvailableRooms.js"></script>
        <script defer='true' src="<%= request.getContextPath() %>/assets/js/reception/main.js"></script>
       
        <!-- Beans -->
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        <jsp:useBean id="typeRoomDB" class="database.DBTypeRoom" scope="request" />
        <jsp:useBean id="bookingDB" class="database.DBBooking" scope="request" />
        
        
        
        <%
            Header header = marketingDB.getHeaderFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            marketingDB.increaseVisitsFromPage(request.getServletPath().replace("/", ""));

        %>
    </head>
    <body>
        
        <h1> Recepción </h1>
        <div id="listTypeRoom">
            <%
           ArrayList<TypeRoom> typeRooms = typeRoomDB.getTypeRooms();
           
           for (int i = 0; i < typeRooms.size(); i++) {
                   out.println("<div class=\"RelationHotelTypeRoom\" >");
                   
                   out.println("<div class=\"namePage\" page=\"rooms.jsp\">");
                   out.println("<h1>" + typeRooms.get(i).getNameHotel()+ "</h1>");
                   out.println("</div>");
                   
                   out.println("<div class=\"typeroom\">");
                   out.println("<span>Habitación: </span>" + typeRooms.get(i).getTypeRoom()+ "");
                   out.println("</div>");
                   
                   out.println("<div class=\"numofavailablerooms\">");
                   out.println("<span>Habitaciones disponibles: </span><input idRHotelTypeRoom='" + typeRooms.get(i).getIdRHotelTypeRoom() + "' onchange=\"updateNumberOfAvailableRooms(this)\" type=\"text\" maxlength=\"50\" name=\"description\" value=\"" + typeRooms.get(i).getNumroomsavailable()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"price\">");
                   out.println("<span>Precio: </span>" + typeRooms.get(i).getPrice()+ "");
                   out.println("</div>");
                   
                   out.println("<div class=\"booking\">");
                   out.println("<center><button class='openModal'>Reservas</button></center>");
                   
                   out.println("</div>");
                   
                   ArrayList<Booking> bookings = bookingDB.getBooking(typeRooms.get(i).getIdTypeRoom(), typeRooms.get(i).getNameHotel());
                   
                   out.println("<div class='myModal modal'>");
                   out.println("<div class='modal-content'>");
                   out.println("<div class='modal-header'>");
                   out.println("<span class='close'>&times;</span>");
                   out.println("<center><h2>Reservas</h2></center>");
                   out.println("</div>");
                   out.println("<center>");
                   out.println("<table>");
                   out.println("<thead>");
                   out.println("<tr>");
                   out.println("<td>");
                   out.println("Adultos");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Hijos");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Fecha de entrada");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Fecha de salida");
                   out.println("</td>");
                   out.println("</tr>");
                   out.println("</thead>");
                   
                   for (int j = 0; j < bookings.size(); j++) {
                       
                       if (bookings.get(j).getIdTypeRoom().equals(typeRooms.get(i).getIdTypeRoom()) &&
                               bookings.get(j).getNameHotel().equals(typeRooms.get(i).getNameHotel())) {
                           out.println("<tr>");
                               out.println("<td> "+bookings.get(j).getAdult()+"</td>");
                               out.println("<td>"+bookings.get(j).getSmallers()+"</td>");
                               out.println("<td>"+bookings.get(j).getEntry_date()+"</td>");
                               out.println("<td>"+bookings.get(j).getDeparture_date()+"</td>");
                            out.println("</tr>");   
                           }
                           
                    }
                   out.println("</table>");
                   out.println("</center>");
                   out.println("</div>");
                   out.println("</div>");
                   out.println("</div>");
               }
        %>
        </div>
    </body>
</html>
