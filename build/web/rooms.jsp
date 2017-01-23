<%-- 
    Document   : rooms
    Created on : 22-nov-2016, 14:47:01
    Author     : jaimescript
--%>

<%@page import="marketing.Header"%>
<%@page import="hotel.Room"%>
<%@page import="hotel.Hotel"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/main.css">
        
        <!-- JS -->
        <script src="<%= request.getContextPath() %>/assets/js/ajax.js"></script>
        <script src="<%= request.getContextPath() %>/assets/js/autocompleteRoomsList.js"></script>
        
        
        <!-- CDN -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    
        <!-- Beans -->
        <jsp:useBean id="hotelDB" class="database.DBHotel" scope="request" />
        <jsp:useBean id="roomDB" class="database.DBRoom" scope="request" />
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        
        <!-- Set title, description, keywords and language -->
        <%
            Header header = marketingDB.getHeaderFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            // Increase a visit on this page
            marketingDB.increaseVisitsFromPage(request.getServletPath().replace("/", ""));

        %>
        
        <!-- Global declarations -->
        <%! 
            public static final int MAX_NUM_ADULTS = 10;
            public static final int MAX_NUM_CHILDREN = 10;
        %>
        
        
    </head>
    <!-- init() initialize ajax funcionality -->
    <body onload="init()">
        <header>
            <nav>
                <img src="<%= request.getContextPath() %>/assets/images/logo.png" width="100" height="100" /> 
            
                <ul>
                    <li class="active">Rooms & Suites</li><span class="whitespace"> </span>
                    <li> Gallery</li><span class="whitespace"> </span>
                    <li> About us</li><span class="whitespace"> </span>
                    <li> Contact us</li><span class="whitespace"> </span>
                </ul>
            </nav>
        </header>
                
                
        <div id="content">
            <!-- Main panel -->
            <div id="panel">
                <h1>Search</h1>
                    Hotel:<br>
                <select name="hotel">
                    <option value="All" selected="selected">Todos</option>

                <%
                    ArrayList<Hotel> hotels = hotelDB.getHotels();
                    for (int i = 0; i < hotels.size(); i++) {
                        out.print("<option value=\"" + hotels.get(i).getName() + "\">" + hotels.get(i).getName() + "</option>");
                    }
                    
                %>

                </select>
                <br>
                Check-in<br>
                <input type="date" id="entryDate" name="checkindate" min="2016-11-21" max="2018-01-01"  value = "2016-11-21" required /><br>
                Check-out<br>
                <input type="date" id="departureDate" name="checkoutdate" min="2016-11-21" max="2018-01-01" value = "2016-11-21" required /><br>
                <table>

                    <tr>
                        <td>
                            Adults
                       </td>
                        <td>
                            <select id="adults" name="adults">
                                <%
                                    for(int i = 1; i <= MAX_NUM_ADULTS; i++){
                                        out.println("<option value="+i+">"+i+"</option>");
                                    }

                                %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Children
                        </td>
                        <td>
                            <select id="children" name="children">
                                <%
                                    for(int i = 0; i <= MAX_NUM_CHILDREN; i++){
                                        out.println("<option value="+i+">"+i+"</option>");
                                    }

                                %>
                            </select> 
                        </td>
                    </tr>


                </table>

                <button onclick="autocompleteRoomsList()">Search</button>
                
                
            </div>
            <div id="listRooms">
                 <!-- Options bar --> 
                <div id="formatConfiguration">
                    <div id="optionsFormat">
                        Price <span class="redColor">▼</span><!-- ▼ ▲ ☰ ☷ -->
                    </div>
                    <div id="typeFormat">
                        <span id="largeViewRoom">☰</span>
                        <span id="shortViewRoom">☷</span>
                    </div>
                </div>
                <div id="typeRoomConfiguration">
                    
                    <%
                        ArrayList<Room> typeRooms = roomDB.getTypeRooms();
                        for (int i = 0; i < typeRooms.size(); i++) {
                                out.print("<span onclick='changeActiveClass(this)' class='active'>" + typeRooms.get(i).getTypeRoom() + "</span>");
                        }
                         
                    %>
                    
                </div>
                    
                <!-- End options bar -->    
                <!-- List of rooms (only completed when we use autocompleteRoomsList --> 
                
                
            </div>
        </div>
    </body>
    
    <!-- Ending scripts -->
    <script src="<%= request.getContextPath() %>/assets/js/rooms/main.js"></script>
</html>
