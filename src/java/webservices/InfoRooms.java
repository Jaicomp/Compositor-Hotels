/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import database.DBHotel;
import database.DBRoom;
import hotel.Hotel;
import hotel.Room;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jaimescript
 */
@WebService(serviceName = "InfoRooms")
public class InfoRooms {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getInfoRooms")
    public String getInfoRooms(@WebParam(name = "entryDate") String entryDate, @WebParam(name = "departureDate") String departureDate) {
        //TODO write your implementation code here:
        ArrayList<Hotel> hotels = new DBHotel().getHotels();
        ArrayList<Room> rooms = new DBRoom().getRooms(entryDate, departureDate);
        String xml = "<hotels>";
        for (int i = 0; i < hotels.size(); i++) {
            xml += "<hotel>";
            xml += "<name>" + hotels.get(i).getName() + "</name>";
            
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j).getHotelName().equals(hotels.get(i).getName())) {
                    xml += "<room>"
                            + "<typeroom>"+rooms.get(j).getTypeRoom()+"</typeroom>"
                            + "<price>"+rooms.get(j).getPrice()+"</price>"
                            + "<numroomsavailable>"+rooms.get(j).getNumRoomsAvailable()+"</numroomsavailable>"
                            + "</room>";
                    
                }
            }
            xml += "</hotel>";
        }
        xml += "</hotels>";
        
        
        return xml;
    }
}
