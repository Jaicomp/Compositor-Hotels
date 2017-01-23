
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInfoRooms_QNAME = new QName("http://webservices/", "getInfoRooms");
    private final static QName _GetInfoRoomsResponse_QNAME = new QName("http://webservices/", "getInfoRoomsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfoRooms }
     * 
     */
    public GetInfoRooms createGetInfoRooms() {
        return new GetInfoRooms();
    }

    /**
     * Create an instance of {@link GetInfoRoomsResponse }
     * 
     */
    public GetInfoRoomsResponse createGetInfoRoomsResponse() {
        return new GetInfoRoomsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getInfoRooms")
    public JAXBElement<GetInfoRooms> createGetInfoRooms(GetInfoRooms value) {
        return new JAXBElement<GetInfoRooms>(_GetInfoRooms_QNAME, GetInfoRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getInfoRoomsResponse")
    public JAXBElement<GetInfoRoomsResponse> createGetInfoRoomsResponse(GetInfoRoomsResponse value) {
        return new JAXBElement<GetInfoRoomsResponse>(_GetInfoRoomsResponse_QNAME, GetInfoRoomsResponse.class, null, value);
    }

}
