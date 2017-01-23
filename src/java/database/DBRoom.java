/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hotel.Booking;
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

    public ArrayList<Room> getRooms(String entryDate, String departureDate) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try {
            ResultSet bookingRooms = accessDB.executeSQLStatement("SELECT COUNT(*) as count,idhotel,idtyperoom FROM \"Booking\" WHERE ('"+entryDate+"' <= entry_date AND '"+departureDate+"' >= departure_date) OR  ('"+entryDate+"'>=entry_date AND '"+entryDate+"'<=departure_date) OR  ('"+departureDate+"'>=entry_date AND '"+departureDate+"'<=departure_date) GROUP BY idhotel, idtyperoom;");
            
            while (bookingRooms.next()) {

                String numRooms = accessDB.toUtf8(bookingRooms.getString("count"));
                String idHotel = accessDB.toUtf8(bookingRooms.getString("idhotel"));
                String idTypeRoom = accessDB.toUtf8(bookingRooms.getString("idtyperoom"));

                bookings.add(new Booking(numRooms, idHotel, idTypeRoom));

            }

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"Hotel\".name as \"hotelName\",\"Hotel\".id as idHotel,\"R_Hotel_TypeRoom\".idtyperoom as \"idtyperoom\" ,\"TypeRoom\".name as \"typeroom\", \"R_Hotel_TypeRoom\".id as \"id\", \"R_Hotel_TypeRoom\".idHotel,\"R_Hotel_TypeRoom\".idTypeRoom, \"R_Hotel_TypeRoom\".numroomsavailable, \"R_Hotel_TypeRoom\".price FROM \"Hotel\" INNER JOIN (\"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom=\"TypeRoom\".id) ON (\"Hotel\".id=\"R_Hotel_TypeRoom\".idhotel);");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int idHotel = resultSet.getInt("idhotel");
                String nameHotel = accessDB.toUtf8(resultSet.getString("hotelName"));
                String typeRoom = accessDB.toUtf8(resultSet.getString("typeroom"));
                String idTypeRoom = accessDB.toUtf8(resultSet.getString("idtyperoom"));
                int numRoomsAvailable = resultSet.getInt("numroomsavailable");
                int price = resultSet.getInt("price");
                for (int i = 0; i < bookings.size(); i++) {

                    if (bookings.get(i).getIdHotel().equals(Integer.toString(idHotel))
                            && bookings.get(i).getIdTypeRoom().equals(idTypeRoom)) {
                        numRoomsAvailable = numRoomsAvailable - Integer.parseInt(bookings.get(i).getNumRooms());
                    }

                }
                
                Room room = new Room(id, nameHotel, typeRoom, numRoomsAvailable, price);
                if (numRoomsAvailable != 0) {
                    rooms.add(room);
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rooms;

    }

    public ArrayList<Room> getRoomsFromHotel(String hotel, String entryDate, String departureDate) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try {

            ResultSet bookingRooms = accessDB.executeSQLStatement("SELECT COUNT(*) as count,idhotel,idtyperoom FROM \"Booking\" WHERE ('"+entryDate+"' <= entry_date AND '"+departureDate+"' >= departure_date) OR  ('"+entryDate+"'>=entry_date AND '"+entryDate+"'<=departure_date) OR  ('"+departureDate+"'>=entry_date AND '"+departureDate+"'<=departure_date) GROUP BY idhotel, idtyperoom;");
            
            
            while (bookingRooms.next()) {

                String numRooms = accessDB.toUtf8(bookingRooms.getString("count"));
                String idHotel = accessDB.toUtf8(bookingRooms.getString("idhotel"));
                String idTypeRoom = accessDB.toUtf8(bookingRooms.getString("idtyperoom"));

                bookings.add(new Booking(numRooms, idHotel, idTypeRoom));

            }

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"Hotel\".name as \"hotelName\",\"TypeRoom\".name as \"typeroom\", \"R_Hotel_TypeRoom\".id as \"id\", \"R_Hotel_TypeRoom\".idHotel,\"R_Hotel_TypeRoom\".idTypeRoom, \"R_Hotel_TypeRoom\".numroomsavailable, \"R_Hotel_TypeRoom\".price FROM \"Hotel\" INNER JOIN (\"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom=\"TypeRoom\".id) ON (\"Hotel\".id=\"R_Hotel_TypeRoom\".idhotel) WHERE \"Hotel\".name='" + hotel + "';");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nameHotel = accessDB.toUtf8(resultSet.getString("hotelName"));
                String typeRoom = accessDB.toUtf8(resultSet.getString("typeroom"));
                int price = resultSet.getInt("price");
                
                String idHotel = accessDB.toUtf8(resultSet.getString("idhotel"));
                String idTypeRoom = accessDB.toUtf8(resultSet.getString("idtyperoom"));
                int numRoomsAvailable = resultSet.getInt("numroomsavailable");
                for (int i = 0; i < bookings.size(); i++) {

                    if (bookings.get(i).getIdHotel().equals(idHotel)
                            && bookings.get(i).getIdTypeRoom().equals(idTypeRoom)) {
                        numRoomsAvailable = numRoomsAvailable - Integer.parseInt(bookings.get(i).getNumRooms());
                    }

                }
                
                Room room = new Room(id, nameHotel, typeRoom, numRoomsAvailable, price);
                if (numRoomsAvailable != 0) {
                    rooms.add(room);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rooms;

    }

    public ArrayList<Room> getTypeRooms() {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try {

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT name FROM \"TypeRoom\"");
            while (resultSet.next()) {

                String typeRoom = accessDB.toUtf8(resultSet.getString("name"));
                Room room = new Room(typeRoom);
                rooms.add(room);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rooms;
    }

    public String getHotelIdFromIdRoom(String idRoom) {
        String idHotel = "";
        try {

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT idhotel FROM \"R_Hotel_TypeRoom\" WHERE id=" + idRoom);
            while (resultSet.next()) {

                idHotel = accessDB.toUtf8(resultSet.getString("idhotel"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idHotel;

    }

    public String getTypeIdFromIdRoom(String idRoom) {
        String idHotel = "";
        try {

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT idtyperoom FROM \"R_Hotel_TypeRoom\" WHERE id=" + idRoom);
            while (resultSet.next()) {

                idHotel = accessDB.toUtf8(resultSet.getString("idtyperoom"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idHotel;

    }

    public String getTypeRoomFromRoomId(String idRoom) {
        String idHotel = "";
        try {

            ResultSet resultSet = accessDB.executeSQLStatement("SELECT \"TypeRoom\".name as \"name\" FROM \"R_Hotel_TypeRoom\" INNER JOIN \"TypeRoom\" ON \"R_Hotel_TypeRoom\".idtyperoom = \"TypeRoom\".id WHERE \"R_Hotel_TypeRoom\".id = " + idRoom + ";");
            while (resultSet.next()) {

                idHotel = accessDB.toUtf8(resultSet.getString("name"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idHotel;

    }

}
