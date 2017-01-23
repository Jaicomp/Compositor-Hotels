/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import Hotel.Room;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

/**
 *
 * @author jaimescript
 */
public class XMLReader {
    
        public ArrayList<Room> getRooms(String s) {
            
        ArrayList<Room> rooms = new ArrayList<Room>();
        RoomHandler handler = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            InputSource in = new InputSource(new StringReader(s));
            handler = new RoomHandler(rooms);
            saxParser.parse(in, handler);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return rooms;
    }
    
}
