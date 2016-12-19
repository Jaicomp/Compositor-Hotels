/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hotel.TypeRoom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimescript
 */
public class DBTypeRoom {
    
    private AccessDB accessDB;
    
    public DBTypeRoom() {
        accessDB = new AccessDB();
    }
    
    public ArrayList<TypeRoom> getTypeRooms() {
        ArrayList<TypeRoom> typeRooms = new ArrayList<>();
        try {
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"R_Hotel_TypeRoom\".id, \"TypeRoom\".name AS \"typeroom\", \"Hotel\".name AS \"namehotel\", \"R_Hotel_TypeRoom\".numroomsavailable, \"R_Hotel_TypeRoom\".price FROM \"Hotel\" INNER JOIN (\"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom=\"TypeRoom\".id) ON \"Hotel\".id=\"R_Hotel_TypeRoom\".idhotel ;");
            
            while(resultSet.next()) {
                
                String RHotelTypeRoom = accessDB.toUtf8(resultSet.getString("id"));
                String typeRoom = accessDB.toUtf8(resultSet.getString("typeroom"));
                String nameHotel = accessDB.toUtf8(resultSet.getString("namehotel"));
                String numroomsavailable = accessDB.toUtf8(resultSet.getString("numroomsavailable"));
                String price = accessDB.toUtf8(resultSet.getString("price"));
                    
                typeRooms.add(new TypeRoom(RHotelTypeRoom, typeRoom, nameHotel, numroomsavailable, price));
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBTypeRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return typeRooms;
    }
    
    
    
}
