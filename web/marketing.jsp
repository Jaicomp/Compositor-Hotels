<%-- 
    Document   : marketing
    Created on : 11-dic-2016, 10:10:35
    Author     : jaimescript
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="marketing.Header"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marketing</title>
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/marketing.css">
       
        <!-- Beans -->
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        
        
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
        
        <%
           ArrayList<Header> headers = marketingDB.getHeaders();
           for (int i = 0; i < headers.size(); i++) {
                   //out.println(headers.get(i).getId());
               }
            
            
        %>
        
        
        <div id="listHeaders">
            <div class="header">
                <div class="namePage">
                    <span>Name's page: </span>rooms.jsp
                </div>
                <div class="title">
                    <span>Title: </span><input type="text" maxlength="50" value="Rooms page" />
                </div>
                <div class="description">
                    <span>Description: </span><input type="text" maxlength="50" value="Booking a room" />
                </div>
                <div class="keywords">
                    <span>Keywords: </span><input type="text" maxlength="50" value="Booking, rooms, hotel" />
                </div>
                <div class="language">
                    <span>Language: </span><input type="text" maxlength="50" value="spanish" />
                </div>
                <div class="visits">
                    <span>Visits: </span>7
                </div>
             
            </div>
            
            
        </div>
        
        
        
        
        
        
        
        
        
    </body>
</html>
