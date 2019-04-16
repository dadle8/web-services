package tk.dadle8.web.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "CountryService")
public class CountryWebService {

    @WebMethod(operationName = "getCountries")
    public List<Country> getCountries(@WebParam(name = "id") String id,
                                      @WebParam(name = "name") String name,
                                      @WebParam(name = "fullname") String fullname,
                                      @WebParam(name = "population") String population,
                                      @WebParam(name = "capital") String capital) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Country> countries = dao.getCountries(id, name, fullname, population, capital);
        return countries;
    }

    @WebMethod(operationName = "createCountry")
    public int createCountry(@WebParam(name = "id") String id,
                             @WebParam(name = "name") String name,
                             @WebParam(name = "fullname") String fullname,
                             @WebParam(name = "population") String population,
                             @WebParam(name = "capital") String capital) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createCountry(id, name, fullname, population, capital);
    }

    @WebMethod(operationName = "updateCountry")
    public boolean updateCountry(@WebParam(name = "id") String id,
                             @WebParam(name = "name") String name,
                             @WebParam(name = "fullname") String fullname,
                             @WebParam(name = "population") String population,
                             @WebParam(name = "capital") String capital) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updateCountry(id, name, fullname, population, capital);
    }

    @WebMethod(operationName = "deleteCountry")
    public boolean deleteCountry(@WebParam(name = "id") String id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deleteCountry(id);
    }
}
