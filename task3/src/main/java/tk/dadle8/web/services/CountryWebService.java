package tk.dadle8.web.services;

import tk.dadle8.web.erros.CountryServiceFault;
import tk.dadle8.web.erros.IllegalValueTypeException;
import tk.dadle8.web.erros.IllegalIdException;

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
                                      @WebParam(name = "capital") String capital) throws IllegalValueTypeException {
        validateIdAndPopulationFields(id, population);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Country> countries = dao.getCountries(id, name, fullname, population, capital);
        return countries;
    }

    @WebMethod(operationName = "createCountry")
    public int createCountry(@WebParam(name = "id") String id,
                             @WebParam(name = "name") String name,
                             @WebParam(name = "fullname") String fullname,
                             @WebParam(name = "population") String population,
                             @WebParam(name = "capital") String capital) throws IllegalValueTypeException {
        validateIdAndPopulationFields(id, population);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createCountry(id, name, fullname, population, capital);
    }

    @WebMethod(operationName = "updateCountry")
    public boolean updateCountry(@WebParam(name = "id") String id,
                                 @WebParam(name = "name") String name,
                                 @WebParam(name = "fullname") String fullname,
                                 @WebParam(name = "population") String population,
                                 @WebParam(name = "capital") String capital) throws IllegalIdException, IllegalValueTypeException {
        validateCountryInDB(id);

        if (population != null && !population.isEmpty()) {
            validateParseValueToInteger(population);
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updateCountry(id, name, fullname, population, capital);
    }

    @WebMethod(operationName = "deleteCountry")
    public boolean deleteCountry(@WebParam(name = "id") String id) throws IllegalIdException, IllegalValueTypeException {
        validateCountryInDB(id);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deleteCountry(id);
    }

    private void validateCountryInDB(String id) throws IllegalIdException, IllegalValueTypeException {
        if (getCountries(id, null, null, null, null).isEmpty()) {
            throw new IllegalIdException("Object with id = '" + id + "' not found in DataBase", CountryServiceFault.defaultInstance());
        }
    }

    private void validateParseValueToInteger(String value) throws IllegalValueTypeException {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalValueTypeException("Can't parse value = '" + value + "' to Integer", CountryServiceFault.defaultInstance());
            }
    }

    private void validateIdAndPopulationFields(String id, String population) throws IllegalValueTypeException {
        if (id != null && !id.isEmpty()) {
            validateParseValueToInteger(id);
        }
        if (population != null && !population.isEmpty()) {
            validateParseValueToInteger(population);
        }
    }
}
