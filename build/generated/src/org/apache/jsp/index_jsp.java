package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("/assets/styles/css/landing.css\">\n");
      out.write("    \n");
      out.write("        <!-- CDN -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("        <img src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/logo.png\" width=\"100\" height=\"100\" />\n");
      out.write("        \n");
      out.write("        <ul>\n");
      out.write("            \n");
      out.write("            <li class=\"active\" ><a href=\"#home\" class=\"tooltip\">•<span class=\"tooltiptext\">Home</span></a></li>\n");
      out.write("            <li><a href=\"#about\" class=\"tooltip\">•<span class=\"tooltiptext\">About</span></a></li>\n");
      out.write("            <li><a href=\"#\" class=\"tooltip\">•<span class=\"tooltiptext\">Rooms</span></a></li>\n");
      out.write("            <li><a href=\"#\" class=\"tooltip\">•<span class=\"tooltiptext\">Services</span></a></li>\n");
      out.write("            <li><a href=\"#\" class=\"tooltip\">•<span class=\"tooltiptext\">Location</span></a></li>\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("        </header>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <div id=\"home\">\n");
      out.write("              <img id=\"mainImage\" src=\"");
      out.print( request.getContextPath() );
      out.write("/assets/images/hotel.jpg\" width=\"100\" height=\"100\"/>\n");
      out.write("              <div id=\"backgroundFilter\"></div>\n");
      out.write("              <h1><hr>Compositor Hotels<br><hr></h1>\n");
      out.write("              <h2>IN MAJORCA</h2>\n");
      out.write("              <a href=\"rooms.jsp\">MAKE A RESERVATION</a>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("            <div id=\"about\">\n");
      out.write("                <p>ASDASD</p>\n");
      out.write("                asdasd<br>\n");
      out.write("                jajajajaj\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("              \n");
      out.write("        <script>\n");
      out.write("        \n");
      out.write("            $(document).ready(function() {\n");
      out.write("               $(\"header ul li\").click(function(event){\n");
      out.write("                if ($(this).attr('class') !== 'active') {\n");
      out.write("                    $(\"header ul li\").removeClass('active');\n");
      out.write("                    $(this).attr('class', 'active');\n");
      out.write("                }\n");
      out.write("               });\n");
      out.write("            });\n");
      out.write("    \n");
      out.write("        </script>\n");
      out.write("              \n");
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
