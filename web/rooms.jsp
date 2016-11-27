<%-- 
    Document   : rooms
    Created on : 22-nov-2016, 14:47:01
    Author     : jaimescript
--%>

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
                    <li>Rooms & Suites</li><span class="whitespace"> </span>
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
                        <option value="SonNet">Son Net</option>
                        <option value="CanBlau">Can Blau</option>
                    </select>
                    <br>
                    Check-in<br>
                    <input type="date" name="checkindate" min="2016-11-21" max="2018-01-01"/><br>
                    Check-out<br>
                    <input type="date" name="checkoutdate" min="2016-11-21" max="2018-01-01"/><br>
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
                                        for(int i = 0; i <= MAXNUMADULTS; i++){

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
                                        for(int i = 1; i <= MAXNUMCHILDREN; i++){

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
                    <span>
                        Suite
                    </span>
                    <span>
                        Junior Suite
                    </span>
                    <span>
                        Doble
                    </span>
                    <span>
                        Doble Vista Mar
                    </span>
                    <span>
                        Individual
                    </span>
                    
                </div>
            </div>
        </div>
    </body>
</html>
