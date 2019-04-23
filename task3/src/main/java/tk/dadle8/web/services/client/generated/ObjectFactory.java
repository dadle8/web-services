
package tk.dadle8.web.services.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tk.dadle8.web.services.client.generated package. 
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

    private final static QName _IllegalIdException_QNAME = new QName("http://services.web.dadle8.tk/", "IllegalIdException");
    private final static QName _CreateCountry_QNAME = new QName("http://services.web.dadle8.tk/", "createCountry");
    private final static QName _DeleteCountryResponse_QNAME = new QName("http://services.web.dadle8.tk/", "deleteCountryResponse");
    private final static QName _GetCountriesResponse_QNAME = new QName("http://services.web.dadle8.tk/", "getCountriesResponse");
    private final static QName _IllegalValueTypeException_QNAME = new QName("http://services.web.dadle8.tk/", "IllegalValueTypeException");
    private final static QName _CreateCountryResponse_QNAME = new QName("http://services.web.dadle8.tk/", "createCountryResponse");
    private final static QName _UpdateCountry_QNAME = new QName("http://services.web.dadle8.tk/", "updateCountry");
    private final static QName _GetCountries_QNAME = new QName("http://services.web.dadle8.tk/", "getCountries");
    private final static QName _UpdateCountryResponse_QNAME = new QName("http://services.web.dadle8.tk/", "updateCountryResponse");
    private final static QName _DeleteCountry_QNAME = new QName("http://services.web.dadle8.tk/", "deleteCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tk.dadle8.web.services.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryServiceFault }
     * 
     */
    public CountryServiceFault createCountryServiceFault() {
        return new CountryServiceFault();
    }

    /**
     * Create an instance of {@link CreateCountryResponse }
     * 
     */
    public CreateCountryResponse createCreateCountryResponse() {
        return new CreateCountryResponse();
    }

    /**
     * Create an instance of {@link UpdateCountry }
     * 
     */
    public UpdateCountry createUpdateCountry() {
        return new UpdateCountry();
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link UpdateCountryResponse }
     * 
     */
    public UpdateCountryResponse createUpdateCountryResponse() {
        return new UpdateCountryResponse();
    }

    /**
     * Create an instance of {@link CreateCountry }
     * 
     */
    public CreateCountry createCreateCountry() {
        return new CreateCountry();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link DeleteCountryResponse }
     * 
     */
    public DeleteCountryResponse createDeleteCountryResponse() {
        return new DeleteCountryResponse();
    }

    /**
     * Create an instance of {@link DeleteCountry }
     * 
     */
    public DeleteCountry createDeleteCountry() {
        return new DeleteCountry();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "IllegalIdException")
    public JAXBElement<CountryServiceFault> createIllegalIdException(CountryServiceFault value) {
        return new JAXBElement<CountryServiceFault>(_IllegalIdException_QNAME, CountryServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "createCountry")
    public JAXBElement<CreateCountry> createCreateCountry(CreateCountry value) {
        return new JAXBElement<CreateCountry>(_CreateCountry_QNAME, CreateCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "deleteCountryResponse")
    public JAXBElement<DeleteCountryResponse> createDeleteCountryResponse(DeleteCountryResponse value) {
        return new JAXBElement<DeleteCountryResponse>(_DeleteCountryResponse_QNAME, DeleteCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "getCountriesResponse")
    public JAXBElement<GetCountriesResponse> createGetCountriesResponse(GetCountriesResponse value) {
        return new JAXBElement<GetCountriesResponse>(_GetCountriesResponse_QNAME, GetCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "IllegalValueTypeException")
    public JAXBElement<CountryServiceFault> createIllegalValueTypeException(CountryServiceFault value) {
        return new JAXBElement<CountryServiceFault>(_IllegalValueTypeException_QNAME, CountryServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "createCountryResponse")
    public JAXBElement<CreateCountryResponse> createCreateCountryResponse(CreateCountryResponse value) {
        return new JAXBElement<CreateCountryResponse>(_CreateCountryResponse_QNAME, CreateCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "updateCountry")
    public JAXBElement<UpdateCountry> createUpdateCountry(UpdateCountry value) {
        return new JAXBElement<UpdateCountry>(_UpdateCountry_QNAME, UpdateCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "getCountries")
    public JAXBElement<GetCountries> createGetCountries(GetCountries value) {
        return new JAXBElement<GetCountries>(_GetCountries_QNAME, GetCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "updateCountryResponse")
    public JAXBElement<UpdateCountryResponse> createUpdateCountryResponse(UpdateCountryResponse value) {
        return new JAXBElement<UpdateCountryResponse>(_UpdateCountryResponse_QNAME, UpdateCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.web.dadle8.tk/", name = "deleteCountry")
    public JAXBElement<DeleteCountry> createDeleteCountry(DeleteCountry value) {
        return new JAXBElement<DeleteCountry>(_DeleteCountry_QNAME, DeleteCountry.class, null, value);
    }

}
