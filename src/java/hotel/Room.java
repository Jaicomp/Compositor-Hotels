/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author jaimescript
 */
public class Room {
    
    private int id;
    private String hotelName;
    private int numRoomsAvailable;
    private int price;
    private String typeRoom;
    
    public Room(int id, String hotelName, String typeroom, int numRoomsAvailable, int price) {
        this.id = id;
        this.hotelName = hotelName;
        this.typeRoom = typeroom;
        this.numRoomsAvailable = numRoomsAvailable;
        this.price = price;
    }
    
    public Room(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getId() {
        return id;
    }


    public int getNumRoomsAvailable() {
        return numRoomsAvailable;
    }

    public int getPrice() {
        return price;
    }
    
    public String getTypeRoom() {
        return typeRoom;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
