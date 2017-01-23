package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Hotel.Room;
import webServiceClient.WSCInfoRooms;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Tribago</title>\n");
      out.write("        \n");
      out.write("        <!-- Styles -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/styles/css/main.css\">\n");
      out.write("        \n");
      out.write("        <!-- Beans -->\n");
      out.write("        ");
      webServiceClient.WSCInfoRooms WSCInfoRooms = null;
      synchronized (request) {
        WSCInfoRooms = (webServiceClient.WSCInfoRooms) _jspx_page_context.getAttribute("WSCInfoRooms", PageContext.REQUEST_SCOPE);
        if (WSCInfoRooms == null){
          WSCInfoRooms = new webServiceClient.WSCInfoRooms();
          _jspx_page_context.setAttribute("WSCInfoRooms", WSCInfoRooms, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      sax.XMLReader xmlReader = null;
      synchronized (request) {
        xmlReader = (sax.XMLReader) _jspx_page_context.getAttribute("xmlReader", PageContext.REQUEST_SCOPE);
        if (xmlReader == null){
          xmlReader = new sax.XMLReader();
          _jspx_page_context.setAttribute("xmlReader", xmlReader, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String entryDate = "2016-11-21";
            String departureDate = "2016-11-21";
            
            if (request.getParameter("entryDate") != null) {
                entryDate = request.getParameter("entryDate");
            }
            
            if (request.getParameter("departureDate") != null) {
                entryDate = request.getParameter("departureDate");
            }
            
        
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <span class=\"blue\">Tri</span><span class=\"yellow\">ba</span><span class=\"red\">go</span>\n");
      out.write("            </nav>\n");
      out.write("            <div id=\"searchEngine\">\n");
      out.write("                <form method=\"POST\" action=\"index.jsp\">\n");
      out.write("                    <input type=\"date\" name=\"entryDate\" value=\"");
      out.print(entryDate);
      out.write("\">\n");
      out.write("                    <input type=\"date\" name=\"departureDate\" value=\"");
      out.print(departureDate);
      out.write("\">\n");
      out.write("                \n");
      out.write("                <input type=\"submit\" name=\"showInfoRooms\" value=\"Buscar\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        ");

            
        if(request.getParameter("showInfoRooms") != null) {
            
            ArrayList<Room> rooms = xmlReader.getRooms(WSCInfoRooms.getInfoRooms(request.getParameter("entryDate"), request.getParameter("departureDate")));
            
            out.println("<div id='rooms'>");
            for (int i = 0; i < rooms.size(); i++) {
                    out.println("<div class='room'>");
                    out.println("<div class='hotel'>Hotel: "+rooms.get(i).getNameHotel()+"</div>");
                    out.println("<div class='typeroom'>"+rooms.get(i).getTypeRoom()+"</div>");
                    out.println("<div class='price'>Price: "+rooms.get(i).getPrice()+"€</div>");
                    out.println("<div class='numroomsavailable'>Number of rooms available: "+rooms.get(i).getNumRoomsAvailable()+"</div>");
                    out.println("</div>");
            }
            out.println("</div>");
            
        }


            
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
