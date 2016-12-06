/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajaxPages;

import database.AccessDB;
import database.DBRoom;
import hotel.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaimescript
 */
public class AutocompleteRoomsList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AutocompleteRoomsList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AutocompleteRoomsList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Room> rooms = null;
        StringBuffer pageContentInXML = new StringBuffer();
        String hotel = request.getParameter("hotel");
        if(hotel.equals("All")){
            
        
            rooms = new DBRoom().getRooms();
        } else {
            rooms = new DBRoom().getRoomsFromHotel(hotel);
        }
     
        
        for (int i = 0; i < rooms.size(); i++) {
            
            pageContentInXML.append("<room>");
            pageContentInXML.append("<id>" + rooms.get(i).getId() + "</id>");
            pageContentInXML.append("<hotel>" + rooms.get(i).getHotelName()+ "</hotel>");
            pageContentInXML.append("<typeRoom>" + rooms.get(i).getTypeRoom()+ "</typeRoom>");
            pageContentInXML.append("<numRoomsAvailable>" + rooms.get(i).getNumRoomsAvailable()+ "</numRoomsAvailable>");
            pageContentInXML.append("<price>" + rooms.get(i).getPrice()+ "</price>");
            pageContentInXML.append("</room>");
            
        }
        
        response.setContentType("text/xml");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<rooms>" + pageContentInXML.toString() + "</rooms>");
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
