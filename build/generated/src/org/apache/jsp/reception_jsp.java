package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hotel.Booking;
import hotel.TypeRoom;
import java.util.ArrayList;
import marketing.Header;

public final class reception_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!-- Title and main Icon -->\n");
      out.write("        <title>Compositor Hotels</title>\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/favicon/favicon-32x32.png\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/favicon/favicon-96x96.png\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/favicon/favicon-16x16.png\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" sizes=\"16x16\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/favicon/favicon.ico\">\n");
      out.write("        \n");
      out.write("        <!-- Styles -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/styles/css/modal.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/styles/css/reception.css\">\n");
      out.write("        \n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/ajax.js\"></script>\n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/updateNumberOfAvailableRooms.js\"></script>\n");
      out.write("        <script defer='true' src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/reception/main.js\"></script>\n");
      out.write("       \n");
      out.write("        <!-- Beans -->\n");
      out.write("        ");
      database.DBMarketing marketingDB = null;
      synchronized (request) {
        marketingDB = (database.DBMarketing) _jspx_page_context.getAttribute("marketingDB", PageContext.REQUEST_SCOPE);
        if (marketingDB == null){
          marketingDB = new database.DBMarketing();
          _jspx_page_context.setAttribute("marketingDB", marketingDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      database.DBTypeRoom typeRoomDB = null;
      synchronized (request) {
        typeRoomDB = (database.DBTypeRoom) _jspx_page_context.getAttribute("typeRoomDB", PageContext.REQUEST_SCOPE);
        if (typeRoomDB == null){
          typeRoomDB = new database.DBTypeRoom();
          _jspx_page_context.setAttribute("typeRoomDB", typeRoomDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      database.DBBooking bookingDB = null;
      synchronized (request) {
        bookingDB = (database.DBBooking) _jspx_page_context.getAttribute("bookingDB", PageContext.REQUEST_SCOPE);
        if (bookingDB == null){
          bookingDB = new database.DBBooking();
          _jspx_page_context.setAttribute("bookingDB", bookingDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            Header header = marketingDB.getHeaderFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            marketingDB.increaseVisitsFromPage(request.getServletPath().replace("/", ""));

        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1> Recepción </h1>\n");
      out.write("        <div id=\"listTypeRoom\">\n");
      out.write("            ");

           ArrayList<TypeRoom> typeRooms = typeRoomDB.getTypeRooms();
           
           for (int i = 0; i < typeRooms.size(); i++) {
                   out.println("<div class=\"RelationHotelTypeRoom\" >");
                   
                   out.println("<div class=\"namePage\" page=\"rooms.jsp\">");
                   out.println("<h1>" + typeRooms.get(i).getNameHotel()+ "</h1>");
                   out.println("</div>");
                   
                   out.println("<div class=\"typeroom\">");
                   out.println("<span>Habitación: </span>" + typeRooms.get(i).getTypeRoom()+ "");
                   out.println("</div>");
                   
                   out.println("<div class=\"numofavailablerooms\">");
                   out.println("<span>Habitaciones disponibles: </span><input idRHotelTypeRoom='" + typeRooms.get(i).getIdRHotelTypeRoom() + "' onchange=\"updateNumberOfAvailableRooms(this)\" type=\"text\" maxlength=\"50\" name=\"description\" value=\"" + typeRooms.get(i).getNumroomsavailable()+ "\" />");
                   out.println("</div>");
                   
                   out.println("<div class=\"price\">");
                   out.println("<span>Precio: </span>" + typeRooms.get(i).getPrice()+ "");
                   out.println("</div>");
                   
                   out.println("<div class=\"booking\">");
                   out.println("<center><button class='openModal'>Reservas</button></center>");
                   
                   out.println("</div>");
                   
                   ArrayList<Booking> bookings = bookingDB.getBooking(typeRooms.get(i).getIdTypeRoom(), typeRooms.get(i).getNameHotel());
                   
                   out.println("<div class='myModal modal'>");
                   out.println("<div class='modal-content'>");
                   out.println("<div class='modal-header'>");
                   out.println("<span class='close'>&times;</span>");
                   out.println("<center><h2>Reservas</h2></center>");
                   out.println("</div>");
                   out.println("<center>");
                   out.println("<table>");
                   out.println("<thead>");
                   out.println("<tr>");
                   out.println("<td>");
                   out.println("Adultos");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Hijos");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Fecha de entrada");
                   out.println("</td>");
                   out.println("<td>");
                   out.println("Fecha de salida");
                   out.println("</td>");
                   out.println("</tr>");
                   out.println("</thead>");
                   
                   for (int j = 0; j < bookings.size(); j++) {
                       
                       if (bookings.get(j).getIdTypeRoom().equals(typeRooms.get(i).getIdTypeRoom()) &&
                               bookings.get(j).getNameHotel().equals(typeRooms.get(i).getNameHotel())) {
                           out.println("<tr>");
                               out.println("<td> "+bookings.get(j).getAdult()+"</td>");
                               out.println("<td>"+bookings.get(j).getSmallers()+"</td>");
                               out.println("<td>"+bookings.get(j).getEntry_date()+"</td>");
                               out.println("<td>"+bookings.get(j).getDeparture_date()+"</td>");
                            out.println("</tr>");   
                           }
                           
                    }
                   out.println("</table>");
                   out.println("</center>");
                   out.println("</div>");
                   out.println("</div>");
                   out.println("</div>");
               }
        
      out.write("\n");
      out.write("        </div>\n");
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
