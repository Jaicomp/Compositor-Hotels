/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hotel.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jaimescript
 */
public class DBRoom {
    
    private AccessDB accessDB;
    
    public DBRoom() {
        accessDB = new AccessDB();
    }
    
    
    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
           
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"Hotel\".name as \"hotelName\",\"TypeRoom\".name as \"typeroom\", \"R_Hotel_TypeRoom\".id as \"id\", \"R_Hotel_TypeRoom\".idHotel,\"R_Hotel_TypeRoom\".idTypeRoom, \"R_Hotel_TypeRoom\".numroomsavailable, \"R_Hotel_TypeRoom\".price FROM \"Hotel\" INNER JOIN (\"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom=\"TypeRoom\".id) ON (\"Hotel\".id=\"R_Hotel_TypeRoom\".idhotel);");
            while (resultSet.next()) {
            
                int idHotel = resultSet.getInt("id");
                String nameHotel = accessDB.toUtf8(resultSet.getString("hotelName"));
                String typeRoom = accessDB.toUtf8(resultSet.getString("typeroom"));
                int numRoomsAvailable = resultSet.getInt("numroomsavailable");
                int price = resultSet.getInt("price");
                Room room = new Room(idHotel, nameHotel, typeRoom, numRoomsAvailable, price);
                rooms.add(room);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return rooms;
        
    }
    
        public ArrayList<Room> getRoomsFromHotel(String hotel) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
           
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"Hotel\".name as \"hotelName\",\"TypeRoom\".name as \"typeroom\", \"R_Hotel_TypeRoom\".id as \"id\", \"R_Hotel_TypeRoom\".idHotel,\"R_Hotel_TypeRoom\".idTypeRoom, \"R_Hotel_TypeRoom\".numroomsavailable, \"R_Hotel_TypeRoom\".price FROM \"Hotel\" INNER JOIN (\"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom=\"TypeRoom\".id) ON (\"Hotel\".id=\"R_Hotel_TypeRoom\".idhotel) WHERE \"Hotel\".name='" + hotel + "';");
            while (resultSet.next()) {
            
                int id = resultSet.getInt("id");
                String nameHotel = accessDB.toUtf8(resultSet.getString("hotelName"));
                String typeRoom = accessDB.toUtf8(resultSet.getString("typeroom"));
                int numRoomsAvailable = resultSet.getInt("numroomsavailable");
                int price = resultSet.getInt("price");
                Room room = new Room(id, nameHotel, typeRoom, numRoomsAvailable, price);
                rooms.add(room);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return rooms;
        
    }
    
    
    
    public ArrayList<Room> getTypeRooms() {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
           
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT name FROM \"TypeRoom\"");
            while (resultSet.next()) {
            
                String typeRoom = accessDB.toUtf8(resultSet.getString("name"));
                Room room = new Room(typeRoom);
                rooms.add(room);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return rooms;
    }
    
    public String getHotelIdFromIdRoom(String idRoom) {
        String idHotel = "";
        try{
           
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT idhotel FROM \"R_Hotel_TypeRoom\" WHERE id="+idRoom);
            while (resultSet.next()) {
            
                idHotel = accessDB.toUtf8(resultSet.getString("idhotel"));
                
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return idHotel;
        
        
        
    }
    
    
    public String getTypeIdFromIdRoom(String idRoom) {
        String idHotel = "";
        try{
           
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT idtyperoom FROM \"R_Hotel_TypeRoom\" WHERE id="+idRoom);
            while (resultSet.next()) {
            
                idHotel = accessDB.toUtf8(resultSet.getString("idtyperoom"));
                
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return idHotel;
        
        
        
    }
            
            
    public String getTypeRoomFromRoomId(String idRoom) {
    String idHotel = "";
    try{

        ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"TypeRoom\".name as \"name\" FROM \"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom = \"TypeRoom\".id WHERE \"R_Hotel_TypeRoom\".id = " + idRoom + ";");
        while (resultSet.next()) {

            idHotel = accessDB.toUtf8(resultSet.getString("name"));

        }
    }catch(SQLException ex) {
        ex.printStackTrace();
    }

    return idHotel;



    }
    
    
    
}
