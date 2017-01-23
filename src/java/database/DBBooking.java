/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hotel.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimescript
 */
public class DBBooking {
    
    private AccessDB accessDB;
    
    public DBBooking() {
        accessDB = new AccessDB();   
    }
    
    
    public void addNewBooking(String adults, String smallers, String entryDate, String departureDate, String idClient, String idHotel, String idTypeRoom) {
        
        try {
            accessDB.executeSQLStatement("INSERT INTO \"Booking\"(adult,smallers,entry_date,departure_date,idclient,idhotel,idtyperoom) "
                    + "values (" + adults + "," + smallers + ",'" + entryDate + "','" + departureDate + "'," + idClient + "," + idHotel + "," + idTypeRoom + ");");
        } catch (SQLException ex) {
            Logger.getLogger(DBBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    public ArrayList<Booking> getBooking(String idTypeRoom, String nameHotel) {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try {
        ResultSet resultSet = accessDB.executeSQLStatement("SELECT adult,smallers,entry_date,departure_date,name,idtyperoom FROM \"Booking\" INNER JOIN \"Hotel\" ON \"Booking\".idhotel=\"Hotel\".id WHERE idtyperoom='" + idTypeRoom + "' AND name='" + nameHotel + "';");
        
        while(resultSet.next()) {
            
            String adult = accessDB.toUtf8(resultSet.getString("adult"));
            String smallers = accessDB.toUtf8(resultSet.getString("smallers"));
            String entryDate = accessDB.toUtf8(resultSet.getString("entry_date"));
            String departureDate = accessDB.toUtf8(resultSet.getString("departure_date"));
            String nameeHotel = accessDB.toUtf8(resultSet.getString("name"));
            String idTypeeRoom = accessDB.toUtf8(resultSet.getString("idtyperoom"));
            
            bookings.add(new Booking(adult,smallers,entryDate,departureDate,nameeHotel,idTypeeRoom));
            
        }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(DBBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookings;
    }
    
    
    
    
}
