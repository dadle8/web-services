
package tk.dadle8.web.services.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CountryWebService", targetNamespace = "http://services.web.dadle8.tk/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CountryWebService {


    /**
     * 
     * @param capital
     * @param name
     * @param id
     * @param fullname
     * @param population
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCountry", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.CreateCountry")
    @ResponseWrapper(localName = "createCountryResponse", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.CreateCountryResponse")
    @Action(input = "http://services.web.dadle8.tk/CountryWebService/createCountryRequest", output = "http://services.web.dadle8.tk/CountryWebService/createCountryResponse")
    public int createCountry(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "fullname", targetNamespace = "")
        String fullname,
        @WebParam(name = "population", targetNamespace = "")
        String population,
        @WebParam(name = "capital", targetNamespace = "")
        String capital);

    /**
     * 
     * @param capital
     * @param name
     * @param id
     * @param fullname
     * @param population
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCountry", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.UpdateCountry")
    @ResponseWrapper(localName = "updateCountryResponse", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.UpdateCountryResponse")
    @Action(input = "http://services.web.dadle8.tk/CountryWebService/updateCountryRequest", output = "http://services.web.dadle8.tk/CountryWebService/updateCountryResponse")
    public boolean updateCountry(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "fullname", targetNamespace = "")
        String fullname,
        @WebParam(name = "population", targetNamespace = "")
        String population,
        @WebParam(name = "capital", targetNamespace = "")
        String capital);

    /**
     * 
     * @param id
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteCountry", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.DeleteCountry")
    @ResponseWrapper(localName = "deleteCountryResponse", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.DeleteCountryResponse")
    @Action(input = "http://services.web.dadle8.tk/CountryWebService/deleteCountryRequest", output = "http://services.web.dadle8.tk/CountryWebService/deleteCountryResponse")
    public boolean deleteCountry(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param capital
     * @param name
     * @param id
     * @param fullname
     * @param population
     * @return
     *     returns java.util.List<tk.dadle8.web.services.client.generated.Country>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCountries", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.GetCountries")
    @ResponseWrapper(localName = "getCountriesResponse", targetNamespace = "http://services.web.dadle8.tk/", className = "tk.dadle8.web.services.client.generated.GetCountriesResponse")
    @Action(input = "http://services.web.dadle8.tk/CountryWebService/getCountriesRequest", output = "http://services.web.dadle8.tk/CountryWebService/getCountriesResponse")
    public List<Country> getCountries(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "fullname", targetNamespace = "")
        String fullname,
        @WebParam(name = "population", targetNamespace = "")
        String population,
        @WebParam(name = "capital", targetNamespace = "")
        String capital);

}
