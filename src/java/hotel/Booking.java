/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.logging.Logger;

/**
 *
 * @author jaimescript
 */
public class Booking {
    
    private String adult;
    private String smallers;
    private String entry_date;
    private String departure_date;
    private String nameHotel;
    private String numRooms;
    private String idHotel;
    private String idTypeRoom;

    public Booking(String adult, String smallers, String entry_date, String departure_date, String nameHotel, String idTypeRoom) {
        this.adult = adult;
        this.smallers = smallers;
        this.entry_date = entry_date;
        this.departure_date = departure_date;
        this.nameHotel = nameHotel;
        this.idTypeRoom = idTypeRoom;
    }
    
    public Booking(String numRooms, String idHotel , String idTypeRoom) {
       this.numRooms = numRooms;
       this.idHotel = idHotel;
       this.idTypeRoom = idTypeRoom;
    }
    private static final Logger LOG = Logger.getLogger(Booking.class.getName());

    public String getNumRooms() {
        return numRooms;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public String getAdult() {
        return adult;
    }

    public String getSmallers() {
        return smallers;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public String getIdTypeRoom() {
        return idTypeRoom;
    }
    
    
    
}
