package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import marketing.Header;

public final class reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Styles -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/styles/css/reservation.css\">\n");
      out.write("        \n");
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
      database.DBBooking bookingDB = null;
      synchronized (request) {
        bookingDB = (database.DBBooking) _jspx_page_context.getAttribute("bookingDB", PageContext.REQUEST_SCOPE);
        if (bookingDB == null){
          bookingDB = new database.DBBooking();
          _jspx_page_context.setAttribute("bookingDB", bookingDB, PageContext.REQUEST_SCOPE);
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
      out.write("        ");
      database.DBClient clientDB = null;
      synchronized (request) {
        clientDB = (database.DBClient) _jspx_page_context.getAttribute("clientDB", PageContext.REQUEST_SCOPE);
        if (clientDB == null){
          clientDB = new database.DBClient();
          _jspx_page_context.setAttribute("clientDB", clientDB, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
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
      out.write("        \n");
      out.write("        ");

            Header header = marketingDB.getHeaderInfoFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            marketingDB.increaseOneVisitOnPage(request.getServletPath().replace("/", ""));


            if ((request.getParameter("adults") != null &&
                    request.getParameter("children") != null &&
                    request.getParameter("idRoom") != null &&
                    request.getParameter("entryDate") != null &&
                    request.getParameter("departureDate") != null) 
                    
                    ) {
                session.setAttribute("adults", request.getParameter("adults"));
                session.setAttribute("children", request.getParameter("children"));
                session.setAttribute("idRoom", request.getParameter("idRoom"));
                session.setAttribute("entryDate", request.getParameter("entryDate"));
                session.setAttribute("departureDate", request.getParameter("departureDate"));
                
                session.setAttribute("idHotel", roomDB.getHotelIdFromIdRoom(request.getParameter("idRoom")));
                session.setAttribute("idTypeRoom", roomDB.getTypeIdFromIdRoom(request.getParameter("idRoom")));
                
                

            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"rooms.jsp\"><img src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/logo.png\" width=\"100\" height=\"100\" /> </a>\n");
      out.write("                <h1>Confirm Reservation</h1>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("            ");

                if (request.getParameter("booking") != null) {
                    /*
                    out.println(session.getAttribute("adults"));
                    out.println(session.getAttribute("children"));
                    out.println(session.getAttribute("entryDate"));
                    out.println(session.getAttribute("departureDate"));
                    out.println(session.getAttribute("idClient"));
                    out.println(session.getAttribute("idHotel"));
                    out.println(session.getAttribute("idTypeRoom"));
                    */
                    
                    bookingDB.addNewBooking(session.getAttribute("adults").toString(),
                            session.getAttribute("children").toString(),
                            session.getAttribute("entryDate").toString(),
                            session.getAttribute("departureDate").toString(),
                            session.getAttribute("idClient").toString(),
                            session.getAttribute("idHotel").toString(),
                            session.getAttribute("idTypeRoom").toString()
                    );
                    
                    
      out.write("\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                    <h1>Gracias por tu reserva</h1>\n");
      out.write("                    <a>Continuar reservando</a>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    ");

                    
                    
                }
                else if (session.getAttribute("username") != null && session.getAttribute("password") != null &&
                        session.getAttribute("adults") != null &&
                        session.getAttribute("children") != null && 
                        session.getAttribute("idRoom") != null) {
                        session.setAttribute("idClient", clientDB.getClientIdFromUsername(session.getAttribute("username").toString()));
                        out.println(session.getAttribute("idClient").toString());
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    <div id=\"reservationSummary\" class=\"panel\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"panelHeader center blue\">\n");
      out.write("                            Reservation Summary\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"contentPanel\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        Hotel:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                           out.println(hotelDB.getNameHotelFromHotelId(session.getAttribute("idHotel").toString()));
                                        
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    \n");
      out.write("                                    <td>\n");
      out.write("                                        Entry date:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            out.println(session.getAttribute("entryDate"));
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        Departure date:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                            out.println(session.getAttribute("departureDate"));
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    \n");
      out.write("                                    <td>\n");
      out.write("                                        Adults:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                        out.println(session.getAttribute("adults"));
                                        
      out.write("\n");
      out.write("                \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        Smallers:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                        out.println(session.getAttribute("children"));
                                        
      out.write("\n");
      out.write("                                        \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        Type room:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        ");

                                        out.println(roomDB.getTypeRoomFromRoomId(session.getAttribute("idRoom").toString()));
                                        
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <form method=\"POST\" action=\"reservation.jsp\">\n");
      out.write("                                            <input class=\"bluebackground\" type=\"submit\" name=\"booking\" value=\"Booking\">\n");
      out.write("                                            \n");
      out.write("                                        </form>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <a href=\"rooms.jsp\">Cancel</a>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                \n");
      out.write("                            </table>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    ");

                }
                else if (request.getParameter("login") != null &&
                    request.getParameter("username") != null &&
                    request.getParameter("password") != null 
                    
                    ) {
                
                if (clientDB.existClient(request.getParameter("username"), request.getParameter("password"))) {
                    
                    session.setAttribute("username", request.getParameter("username"));
                    session.setAttribute("password", request.getParameter("password"));
                    response.sendRedirect("reservation.jsp");
                    
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

                response.sendRedirect("reservation.jsp");
            } else {
                
            
      out.write("\n");
      out.write("                <div class=\"panel\" >\n");
      out.write("                    <div class=\"panelHeader center blue\">\n");
      out.write("                        Log in\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"contentPanel\">\n");
      out.write("                        <form method=\"POST\" action=\"reservation.jsp\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"username\" placeholder=\"username\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"password\" placeholder=\"password\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input class=\"bluebackground\" type=\"submit\" name=\"login\" value=\"Confirm\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div id=\"signup\" class=\"panel\">\n");
      out.write("                    <div class=\"panelHeader center green\">\n");
      out.write("                        Sign up\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"contentPanel\">\n");
      out.write("                        <form method=\"POST\" action=\"reservation.jsp\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"username\" placeholder=\"username\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"password\" placeholder=\"password\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"firstname\" placeholder=\"firstname\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"lastname\" placeholder=\"lastname\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" size=\"30\" maxlength=\"50\" name=\"email\" placeholder=\"email\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input class=\"greenbackground\" type=\"submit\" name=\"signup\" value=\"Register\" required>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                ");

                  }  
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                  \n");
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
