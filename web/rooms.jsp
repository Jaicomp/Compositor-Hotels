<%-- 
    Document   : rooms
    Created on : 22-nov-2016, 14:47:01
    Author     : jaimescript
--%>

<%@page import="hotel.Room"%>
<%@page import="hotel.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compositor Hotels</title>
        <link rel="icon" type="image/png" sizes="32x32" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-16x16.png">
        <link rel="shortcut icon" type="image/x-icon" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon.ico">
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/main.css">
        
        <!-- CDN -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    
        <!-- Beans -->
        <jsp:useBean id="hotelDB" class="database.DBHotel" scope="request" />
        <jsp:useBean id="roomDB" class="database.DBRooms" scope="request" />
        
        <!-- Declarations -->
        <%! public static final int MAXNUMROOMS = 10;
            public static final int MAXNUMADULTS = 10;
            public static final int MAXNUMCHILDREN = 10;
        
        %>
    </head>
    <body>
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
            
            <div id="panel">
                <form>
                    <h1>Search</h1>
                        Hotel:<br>
                    <select name="hotel">
                        <option value="All">Todos</option>
                        
                    <%
                        ArrayList<Hotel> hotels = hotelDB.getHotels();
                        
                        for (int i = 0; i < hotels.size(); i++) {
                            out.print("<option value=\"" + hotels.get(i).getName() + "\">" + hotels.get(i).getName() + "</option>");
                        }
            
                    %>
                        
                    </select>
                    <br>
                    Check-in<br>
                    <input type="date" name="checkindate" min="2016-11-21" max="2018-01-01" required /><br>
                    Check-out<br>
                    <input type="date" name="checkoutdate" min="2016-11-21" max="2018-01-01" required /><br>
                    <table>
                        <tr>
                            <td>
                                Rooms 
                            </td>
                            <td>
                                <select name="numRooms">
                                    <%
                                    for(int i = 1; i <= MAXNUMROOMS; i++){
                                              
                                        out.println("<option value="+i+">"+i+"</option>");
                                    }
                                            
                                    %>
                                </select> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Adults
                           </td>
                            <td>
                                <select name="adults">
                                    <%
                                        for(int i = 1; i <= MAXNUMADULTS; i++){

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
                                <select name="children">
                                    <%
                                        for(int i = 0; i <= MAXNUMCHILDREN; i++){

                                            out.println("<option value="+i+">"+i+"</option>");
                                        }

                                    %>
                                </select> 
                            </td>
                        </tr>


                    </table>
                                
                    <button>Search</button>

                </form>
            </div>
            <div id="listRooms">
                <div id="formatConfiguration">
                    <div id="optionsFormat">
                        Price <span class="redColor">▼</span><!-- ▼ ▲ ☰ ☷ -->
                    </div>
                    <div id="typeFormat">
                        <span>☰</span>
                        <span>☷</span>
                    </div>
                </div>
                <div id="typeRoomConfiguration">
                    
                    <%
                        ArrayList<Room> typeRooms = roomDB.getTypeRooms();
                        for (int i = 0; i < typeRooms.size(); i++) {
                                out.print("<span>" + typeRooms.get(i).getTypeRoom() + "</span>");
                            }
                        
                        
                        %>
                </div>
                
                
                <%
                        ArrayList<Room> rooms = roomDB.getRooms();
                        out.print(rooms.get(0).getTypeRoom());
                        for (int i = 0; i < rooms.size(); i++) {
                                out.print("<div class='room'>");
                                out.print("<img class='imageRoom' src='http://www.srisrivaastu.com/image/peh-superior-room.jpg'alt='room' width='200' height='200' >");
                                out.print("<div class='nameHotel'>" + rooms.get(i).getHotelName() + "</div>");
                                out.print("<div class='price'>€" + rooms.get(i).getPrice() + "</div>");
                                out.print("<div class='typeRoom'><img src='"+request.getContextPath()+"/assets/images/numpeopleroom.svg' width='20' height='20'/>" + rooms.get(i).getTypeRoom() +"</div>");
                                out.print("<button class='bookingButton'>Reservar habitación ➤</button>");
                                out.print("</div>");
                        }
                        
                        
                %>
                
                
                <div class="room">
                    <img class="imageRoom"src="http://www.srisrivaastu.com/image/peh-superior-room.jpg"
                         alt="room" width="200" height="200" >
                    <div class="nameHotel">Hotel SonNet</div>
                    <div class="price">€350</div>
                    <div class="typeRoom"><img src="<%= request.getContextPath() %>/assets/images/numpeopleroom.svg" width="20" height="20"/> Doble Vista Mar</div>
                    <button class="bookingButton">Reservar habitación ➤</button>
                </div>
                <div class="room">
                    <img class="imageRoom"src="http://www.srisrivaastu.com/image/peh-superior-room.jpg"
                         alt="room" width="200" height="200" >
                    <div class="nameHotel">Hotel SonNet</div>
                    <div class="price">€350</div>
                    <div class="typeRoom"><img src="<%= request.getContextPath() %>/assets/images/numpeopleroom.svg" width="20" height="20"/> Doble Vista Mar</div>
                    <button class="bookingButton">Reservar habitación ➤</button>
                </div>
            </div>
        </div>
    </body>
</html>
