/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServiceClient;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;

/**
 *
 * @author jaimescript
 */
public class WSCInfoRooms {

    public String getInfoRooms(java.lang.String entryDate, java.lang.String departureDate) {
        webservices.InfoRooms_Service service = new webservices.InfoRooms_Service();
        webservices.InfoRooms port = service.getInfoRoomsPort();
        return port.getInfoRooms(entryDate, departureDate);
    }

    
}
