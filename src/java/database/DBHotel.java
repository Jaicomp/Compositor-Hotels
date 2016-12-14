/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hotel.Hotel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jaimescript
 */
public class DBHotel {
    
    private AccessDB accessDB;
    
    public DBHotel() {
        accessDB = new AccessDB();
    }
    
    public ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        
        try {
            
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT name FROM \"Hotel\"");
            while (resultSet.next()) {
            
                String name = accessDB.toUtf8(resultSet.getString("name"));
                Hotel hotel = new Hotel(name);
                hotels.add(hotel);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return hotels;
        
    }
    

    
}
