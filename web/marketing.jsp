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
        <!-- Title and main Icon -->
        <title>Compositor Hotels</title>
        <link rel="icon" type="image/png" sizes="32x32" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon-16x16.png">
        <link rel="shortcut icon" type="image/x-icon" sizes="16x16" href="<%= request.getContextPath() %>/assets/images/favicon/favicon.ico">
        
        
        <!-- Styles -->
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/styles/css/marketing.css">
        
        <!-- JS -->
        <script src="<%= request.getContextPath() %>/assets/js/ajax.js"></script>
        <script src="<%= request.getContextPath() %>/assets/js/updateMetaTag.js"></script>
       
        <!-- Beans -->
        <jsp:useBean id="marketingDB" class="database.DBMarketing" scope="request" />
        
        
        
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
        
        <h1> Marketing </h1>
        <div id="listHeaders">
        <%
           ArrayList<Header> headers = marketingDB.getHeaders();
           for (int i = 0; i < headers.size(); i++) {
                   out.println("<div class=\"header\" page=\"" + headers.get(i).getPage() + "\">");
                   
                   out.println("<div class=\"namePage\" page=\"rooms.jsp\">");
                   out.println("<h1>" + headers.get(i).getPage()+ "</h1>");
                   out.println("</div>");
                   
                   out.println("<div class=\"title\">");
                   out.println("<span>Title: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"title\" value=\"" + headers.get(i).getTitle() + "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"description\">");
                   out.println("<span>Description: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"description\" value=\"" + headers.get(i).getDescription()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"keywords\">");
                   out.println("<span>Keywords: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"keywords\" value=\"" + headers.get(i).getKeywords()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"language\">");
                   out.println("<span>Language: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"language\" value=\"" + headers.get(i).getLanguage()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"visits\">");
                   out.println("<span>Visits: </span>"+headers.get(i).getVisits());
                   out.println("</div>");
                   
                   out.println("</div>");
               }
            
            
        %>
        </div>
        
    </body>
</html>
