package com.example.jaimescript.tribago;

/**
 * Created by jaimescript on 23/01/17.
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class RoomHandler extends DefaultHandler {

    ArrayList<Room> rooms = new ArrayList<Room>();
    Room room;
    private String nameHotel;

    private boolean tagRoom = false;
    private boolean tagNameHotel = false;
    private boolean tagTypeRoom = false;
    private boolean tagPrice = false;
    private boolean tagNumRoomsAvailable = false;

    public RoomHandler(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("name")) {
            tagNameHotel = true;
        } else if (qName.equalsIgnoreCase("room")) {
            tagRoom = true;
            room = new Room();
        } else if (qName.equalsIgnoreCase("typeroom")) {
            tagTypeRoom = true;
        } else if (qName.equalsIgnoreCase("price")) {
            tagPrice = true;
        } else if (qName.equalsIgnoreCase("numroomsavailable")) {
            tagNumRoomsAvailable = true;
        }

    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        if (qName.equalsIgnoreCase("name")) {
            tagNameHotel = false;

        } else if (qName.equalsIgnoreCase("room")) {
            tagRoom = false;
            rooms.add(room);

        } else if (qName.equalsIgnoreCase("typeroom")) {
            tagTypeRoom = false;
        }else if (qName.equalsIgnoreCase("price")) {
            tagPrice = false;
        } else if (qName.equalsIgnoreCase("numroomsavailable")) {
            tagNumRoomsAvailable = false;
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String text = new String(ch, start, length).trim();

        if (tagNameHotel) {
            nameHotel = text;
        } else if (tagTypeRoom) {
            room.setNameHotel(nameHotel);
            room.setTypeRoom(text);
        } else if (tagPrice) {
            room.setPrice(text);
        } else if (tagNumRoomsAvailable) {
            room.setNumRoomsAvailable(text);
        }


    }

}
