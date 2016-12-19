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
public class TypeRoom {
 
    private String idTypeRoom;
    private String typeRoom;
    private String nameHotel;
    private String numroomsavailable;
    private String price;
    
    public TypeRoom(String idRHotelTypeRoom, String typeRoom,String nameHotel,String numroomsavailable,String price) {
       
        this.idTypeRoom = idRHotelTypeRoom;
        this.typeRoom = typeRoom;
        this.nameHotel = nameHotel;
        this.numroomsavailable = numroomsavailable;
        this.price = price;
    }


    public String getIdRHotelTypeRoom() {
        return idTypeRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public String getNumroomsavailable() {
        return numroomsavailable;
    }

    public String getPrice() {
        return price;
    }
    
}
