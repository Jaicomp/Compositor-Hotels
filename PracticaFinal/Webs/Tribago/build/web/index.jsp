<%-- 
    Document   : index
    Created on : 20-ene-2017, 17:11:58
    Author     : jaimescript
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Hotel.Room"%>
<%@page import="webServiceClient.WSCInfoRooms"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tribago</title>
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/main.css">
        
        <!-- Beans -->
        <jsp:useBean id="WSCInfoRooms" class="webServiceClient.WSCInfoRooms" scope="request" />
        <jsp:useBean id="xmlReader" class="sax.XMLReader" scope="request" />
        
    </head>
    <body>
        <%
            String entryDate = "2016-11-21";
            String departureDate = "2016-11-21";
            
            if (request.getParameter("entryDate") != null) {
                entryDate = request.getParameter("entryDate");
            }
            
            if (request.getParameter("departureDate") != null) {
                entryDate = request.getParameter("departureDate");
            }
            
        %>
        <header>
            <nav>
                <span class="blue">Tri</span><span class="yellow">ba</span><span class="red">go</span>
            </nav>
            <div id="searchEngine">
                <form method="POST" action="index.jsp">
                    <input type="date" name="entryDate" value="<%=entryDate%>">
                    <input type="date" name="departureDate" value="<%=departureDate%>">
                
                <input type="submit" name="showInfoRooms" value="Buscar">
                </form>
            </div>
        </header>
        
        <%
            
        if(request.getParameter("showInfoRooms") != null) {
            
            ArrayList<Room> rooms = xmlReader.getRooms(WSCInfoRooms.getInfoRooms(request.getParameter("entryDate"), request.getParameter("departureDate")));
            
            out.println("<div id='rooms'>");
            for (int i = 0; i < rooms.size(); i++) {
                    out.println("<div class='room'>");
                    out.println("<div class='hotel'>Hotel: "+rooms.get(i).getNameHotel()+"</div>");
                    out.println("<div class='typeroom'>"+rooms.get(i).getTypeRoom()+"</div>");
                    out.println("<div class='price'>Precio "+rooms.get(i).getPrice()+"€</div>");
                    out.println("<div class='numroomsavailable'>Habitaciones disponibles: "+rooms.get(i).getNumRoomsAvailable()+"</div>");
                    out.println("</div>");
            }
            out.println("</div>");
            
        }


            
        %>
        
        
        
    </body>
</html>
