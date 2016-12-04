package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hotel.Room;
import hotel.Hotel;
import java.util.ArrayList;

public final class rooms_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public static final int MAXNUMROOMS = 10;
            public static final int MAXNUMADULTS = 10;
            public static final int MAXNUMCHILDREN = 10;
        
        
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
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
      out.write("/assets/styles/css/main.css\">\n");
      out.write("        \n");
      out.write("        <!-- JS --> \n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/ajax.js\"></script>\n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/autocompleteroomslist.js\"></script>\n");
      out.write("        \n");
      out.write("        <!-- CDN -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("    \n");
      out.write("        <!-- Beans -->\n");
      out.write("        ");
      database.DBHotel hotelDB = null;
      synchronized (request) {
        hotelDB = (database.DBHotel) _jspx_page_context.getAttribute("hotelDB", PageContext.REQUEST_SCOPE);
        if (hotelDB == null){
          hotelDB = new database.DBHotel();
          _jspx_page_context.setAttribute("hotelDB", hotelDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      database.DBRoom roomDB = null;
      synchronized (request) {
        roomDB = (database.DBRoom) _jspx_page_context.getAttribute("roomDB", PageContext.REQUEST_SCOPE);
        if (roomDB == null){
          roomDB = new database.DBRoom();
          _jspx_page_context.setAttribute("roomDB", roomDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- Declarations -->\n");
      out.write("        ");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"init()\">\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <img src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/logo.png\" width=\"100\" height=\"100\" /> \n");
      out.write("            \n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"active\">Rooms & Suites</li><span class=\"whitespace\"> </span>\n");
      out.write("                    <li> Gallery</li><span class=\"whitespace\"> </span>\n");
      out.write("                    <li> About us</li><span class=\"whitespace\"> </span>\n");
      out.write("                    <li> Contact us</li><span class=\"whitespace\"> </span>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            \n");
      out.write("            <div id=\"panel\">\n");
      out.write("                <h1>Search</h1>\n");
      out.write("                    Hotel:<br>\n");
      out.write("                <select name=\"hotel\">\n");
      out.write("                    <option value=\"All\">Todos</option>\n");
      out.write("\n");
      out.write("                ");

                    ArrayList<Hotel> hotels = hotelDB.getHotels();

                    for (int i = 0; i < hotels.size(); i++) {
                        out.print("<option value=\"" + hotels.get(i).getName() + "\">" + hotels.get(i).getName() + "</option>");

                    }

                
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <br>\n");
      out.write("                Check-in<br>\n");
      out.write("                <input type=\"date\" name=\"checkindate\" min=\"2016-11-21\" max=\"2018-01-01\" required /><br>\n");
      out.write("                Check-out<br>\n");
      out.write("                <input type=\"date\" name=\"checkoutdate\" min=\"2016-11-21\" max=\"2018-01-01\" required /><br>\n");
      out.write("                <table>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            Adults\n");
      out.write("                       </td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"adults\">\n");
      out.write("                                ");

                                    for(int i = 1; i <= MAXNUMADULTS; i++){

                                        out.println("<option value="+i+">"+i+"</option>");
                                    }

                                
      out.write("\n");
      out.write("                            </select> \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            Children\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"children\">\n");
      out.write("                                ");

                                    for(int i = 0; i <= MAXNUMCHILDREN; i++){

                                        out.println("<option value="+i+">"+i+"</option>");
                                    }

                                
      out.write("\n");
      out.write("                            </select> \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("                <button onclick=\"autocompleteRoomsList()\">Search</button>\n");
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div id=\"listRooms\">\n");
      out.write("                <div id=\"formatConfiguration\">\n");
      out.write("                    <div id=\"optionsFormat\">\n");
      out.write("                        Price <span class=\"redColor\">▼</span><!-- ▼ ▲ ☰ ☷ -->\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"typeFormat\">\n");
      out.write("                        <span>☰</span>\n");
      out.write("                        <span>☷</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"typeRoomConfiguration\">\n");
      out.write("                    \n");
      out.write("                    ");

                        ArrayList<Room> typeRooms = roomDB.getTypeRooms();
                        for (int i = 0; i < typeRooms.size(); i++) {
                                out.print("<span>" + typeRooms.get(i).getTypeRoom() + "</span>");
                            }
                        
                        
                        
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <!--\n");
      out.write("                ");

                        ArrayList<Room> rooms = roomDB.getRooms();
                        for (int i = 0; i < rooms.size(); i++) {
                                out.print("<div class='room'>");
                                out.print("<img class='imageRoom' src='http://www.srisrivaastu.com/image/peh-superior-room.jpg'alt='room' width='200' height='200' >");
                                out.print("<div class='nameHotel'>" + rooms.get(i).getHotelName() + "</div>");
                                out.print("<div class='price'>€" + rooms.get(i).getPrice() + "</div>");
                                out.print("<div class='typeRoom'><img src='"+request.getContextPath()+"/assets/images/numpeopleroom.svg' width='20' height='20'/>" + rooms.get(i).getTypeRoom() +"</div>");
                                out.print("<button class='bookingButton'>Reservar habitación ➤</button>");
                                out.print("<div class='numberOfRoomsAvailable'>Habitaciones disponibles: " + rooms.get(i).getNumRoomsAvailable() + "</div>");
                                out.print("</div>");
                
                        }
                        
                        
                
      out.write("\n");
      out.write("                -->\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                <div class=\"room\">\n");
      out.write("                    <img class=\"imageRoom\"src=\"http://www.srisrivaastu.com/image/peh-superior-room.jpg\"\n");
      out.write("                         alt=\"room\" width=\"200\" height=\"200\" >\n");
      out.write("                    <div class=\"nameHotel\">Hotel SonNet</div>\n");
      out.write("                    <div class=\"price\">€350</div>\n");
      out.write("                    <div class=\"typeRoom\"><img src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/numpeopleroom.svg\" width=\"20\" height=\"20\"/> Doble Vista Mar</div>\n");
      out.write("                    <div class=\"numberOfRoomsAvailable\">Habitaciones disponibles: 50</div>\n");
      out.write("                    <button class=\"bookingButton\">Reservar habitación ➤</button>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("            \n");
      out.write("            </div>\n");
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