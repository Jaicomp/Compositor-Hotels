<%-- 
    Document   : borrar
    Created on : 29-nov-2016, 19:14:17
    Author     : jaimescript
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <jsp:useBean id="UT" class="database.Utils" scope="request" />
        <%
           
            out.print(UT.hola(request, response) + "<br>");
            
            
        %>
        
    </body>
</html>
