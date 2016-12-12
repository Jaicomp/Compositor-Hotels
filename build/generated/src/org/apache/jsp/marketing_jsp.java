package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import marketing.Header;

public final class marketing_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Marketing</title>\n");
      out.write("        \n");
      out.write("        <!-- Styles -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/styles/css/marketing.css\">\n");
      out.write("        \n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/ajax.js\"></script>\n");
      out.write("        <script src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/js/updateMetaTag.js\"></script>\n");
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
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            Header header = marketingDB.getHeaderInfoFromPage(request.getServletPath().replace("/", ""));
            
            out.println("<meta name=\"title\" content="+ header.getTitle()+"/>");
            out.println("<meta name=\"description\" content="+ header.getDescription() +"/>");
            out.println("<meta name=\"keywords\" content="+ header.getKeywords()+"/>");
            out.println("<meta name=\"language\" content="+ header.getLanguage()+"/>");
            
            marketingDB.increaseOneVisitOnPage(request.getServletPath().replace("/", ""));

        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1> Marketing </h1>\n");
      out.write("        <div id=\"listHeaders\">\n");
      out.write("        ");

           ArrayList<Header> headers = marketingDB.getHeaders();
           for (int i = 0; i < headers.size(); i++) {
                   out.println("<div class=\"header\" page=\"" + headers.get(i).getNamePage() + "\">");
                   
                   out.println("<div class=\"namePage\" page=\"rooms.jsp\">");
                   out.println("<span>Name's page: </span>"+headers.get(i).getNamePage());
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
                   out.println("<span>Visits: </span>"+headers.get(i).getVisited());
                   out.println("</div>");
                   
                   out.println("</div>");
               }
            
            
        
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write(" <!--\n");
      out.write("            <div class=\"header\" page=\"rooms.jsp\">\n");
      out.write("                <div class=\"namePage\" >\n");
      out.write("                    <span>Name's page: </span>rooms.jsp\n");
      out.write("                </div>\n");
      out.write("                <div class=\"title\">\n");
      out.write("                    <span>Title: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"title\" value=\"Rooms page\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"description\">\n");
      out.write("                    <span>Description: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"description\" value=\"Booking a room\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"keywords\">\n");
      out.write("                    <span>Keywords: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"keywords\" value=\"Booking, rooms, hotel\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"language\">\n");
      out.write("                    <span>Language: </span><input onchange=\"updateMetaTag(this)\" type=\"text\" maxlength=\"50\" name=\"language\" value=\"spanish\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"visits\">\n");
      out.write("                    <span>Visits: </span>7\n");
      out.write("                </div>\n");
      out.write("             \n");
      out.write("            </div>\n");
      out.write("       \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("         -->    \n");
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
