package com.example.jaimescript.tribago;

/**
 * Created by jaimescript on 23/01/17.
 */

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class WSA {

    private static final String SOAP_ACTION = "http://10.0.2.2:36407/CompositorHotels/";
    private static final String METHOD_NAME = "getInfoRooms";
    private static final String NAMESPACE = "http://webservices/";
    private static final String URL = "http://10.0.2.2:36407/CompositorHotels/InfoRooms?WSDL";

    public WSA() {
    }



    public String getRooms(String entryDate, String departureDate) {
        String res = "ERROR";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo p1 = new PropertyInfo();
        PropertyInfo p2 = new PropertyInfo();


        p1.setName("entryDate");
        p1.setValue(entryDate);
        p1.setType(String.class);


        p2.setName("departureDate");
        p2.setValue(departureDate);
        p2.setType(String.class);

        request.addProperty(p1);
        request.addProperty(p2);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE ht = new HttpTransportSE(URL);
        try {
            ht.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            res = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
