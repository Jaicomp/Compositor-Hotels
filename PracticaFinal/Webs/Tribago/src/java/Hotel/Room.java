/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

/**
 *
 * @author jaimescript
 */
public class Room {
    
    private String nameHotel;
    private String nameRoom;
    private String typeRoom;
    private String price;
    private String numRoomsAvailable;
    
    public Room() {
        
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumRoomsAvailable() {
        return numRoomsAvailable;
    }

    public void setNumRoomsAvailable(String numRoomsAvailable) {
        this.numRoomsAvailable = numRoomsAvailable;
    }
    
}
