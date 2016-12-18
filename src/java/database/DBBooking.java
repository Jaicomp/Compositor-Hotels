/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
    
    
}
