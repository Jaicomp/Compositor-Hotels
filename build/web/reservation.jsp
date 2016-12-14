<%-- 
    Document   : reservation
    Created on : 13-dic-2016, 8:43:18
    Author     : jaimescript
--%>

<%@page import="marketing.Header"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/reservation.css">
        
        <!-- Beans -->
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        <jsp:useBean id="clientDB" class="database.DBClient" scope="request" />
        
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
        <header>
            <nav>
                <a href="rooms.jsp"><img src="<%= request.getContextPath() %>/assets/images/logo.png" width="100" height="100" /> </a>
                <h1>Confirm Reservation</h1>
            </nav>
        </header>

        <div id="content">
            <%
                if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
                    
                    
                    %>
                    
                    <div id="reservationSummary" class="panel">
                        
                        <div class="panelHeader center blue">
                            Reservation Summary
                        </div>
                        <div class="contentPanel">
                            <table>
                                <tr>
                                    <td>
                                        Hotel:
                                    </td>
                                    <td>
                                        Son Net
                                    </td>
                                </tr>
                                <tr>
                                    
                                    <td>
                                        Entry date:
                                    </td>
                                    <td>
                                        17-09-2016
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Departure date:
                                    </td>
                                    <td>
                                        17-09-2016
                                    </td>
                                </tr>
                                <tr>
                                    
                                    <td>
                                        Adults:
                                    </td>
                                    <td>
                                        2
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Smallers:
                                    </td>
                                    <td>
                                        3
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Type room:
                                    </td>
                                    <td>
                                        Suite
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form>
                                            <input class="bluebackground" type="submit" name="booking" value="Booking">
                                            
                                        </form>
                                    </td>
                                    <td>
                                        <a href="rooms.jsp">Cancel</a>
                                    </td>
                                </tr>
                                
                            </table>
                            
                        </div>
                        
                        
                    </div>
                    
                    
                    <%
                }
                else if (request.getParameter("login") != null && 
                    request.getParameter("username") != null &&
                    request.getParameter("password") != null 
                    
                    ) {
                
                if (clientDB.existClient(request.getParameter("username"), request.getParameter("password"))) {
                    session.setAttribute("username", request.getParameter("username"));
                    session.setAttribute("password", request.getParameter("password"));
                    
                } else {
                    response.sendRedirect("reservation.jsp");
                }
                
            } else if (request.getParameter("signup") != null &&
                    request.getParameter("username") != null &&
                    request.getParameter("password") != null &&
                    request.getParameter("firstname") != null && 
                    request.getParameter("lastname") != null && 
                    request.getParameter("email") != null
                    ) {
                
                clientDB.addNewClient(request.getParameter("username"), request.getParameter("password"), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"));
                
                session.setAttribute("username", request.getParameter("username"));
                session.setAttribute("password", request.getParameter("password"));
            } else {
                
            %>
                <div class="panel" >
                    <div class="panelHeader center blue">
                        Log in
                    </div>
                    <div class="contentPanel">
                        <form method="POST" action="reservation.jsp">
                            <table>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="username" placeholder="username" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="password" placeholder="password" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input class="bluebackground" type="submit" name="login" value="Confirm">
                                    </td>
                                </tr>

                            </table>
                        </form>
                    </div>

                </div>
                <div id="signup" class="panel">
                    <div class="panelHeader center green">
                        Sign up
                    </div>
                    <div class="contentPanel">
                        <form method="POST" action="reservation.jsp">
                            <table>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="username" placeholder="username" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="password" placeholder="password" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="firstname" placeholder="firstname" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="lastname" placeholder="lastname" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" size="30" maxlength="50" name="email" placeholder="email" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input class="greenbackground" type="submit" name="signup" value="Register" required>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                <%
                  }  
                %>
            </div>
        </div>
                  
    </body>
</html>
