<%-- 
    Document   : tribago
    Created on : 14-dic-2016, 15:36:50
    Author     : jaimescript
--%>

<%@page import="marketing.Header"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tribago</title>
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/tribago.css">
        
        
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
        
        <header>
            <nav>
                <span class="blue">Tri</span><span class="yellow">ba</span><span class="red">go</span>
            </nav>
            <div id="searchEngine">
                <input type="date">
                <input type="date">
                <input type="submit" value="Buscar">
            
            </div>
        </header>
        
        
        
        
    </body>
</html>
