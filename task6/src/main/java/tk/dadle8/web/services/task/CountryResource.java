package tk.dadle8.web.services.task;

import tk.dadle8.web.services.task.erros.IllegalIdException;
import tk.dadle8.web.services.task.erros.IllegalValueTypeException;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/countries")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource {

    @GET
    public List<Country> getCountries(@QueryParam("id") String id,
                                      @QueryParam("name") String name,
                                      @QueryParam("fullname") String fullname,
                                      @QueryParam("population") String population,
                                      @QueryParam("capital") String capital) throws IllegalValueTypeException {
        validateIdAndPopulationFields(id, population);
        return new PostgreSQLDAO().getCountries(id, name, fullname, population, capital);
    }

    @POST
    public String createCountry(@QueryParam("id") String id,
                                @QueryParam("name") String name,
                                @QueryParam("fullname") String fullname,
                                @QueryParam("population") String population,
                                @QueryParam("capital") String capital) throws IllegalValueTypeException {
        validateIdAndPopulationFields(id, population);
        return Integer.toString(new PostgreSQLDAO().createCountry(id, name, fullname, population, capital));
    }

    @PUT
    public String updateCountry(@QueryParam("id") String id,
                                @QueryParam("name") String name,
                                @QueryParam("fullname") String fullname,
                                @QueryParam("population") String population,
                                @QueryParam("capital") String capital) throws IllegalIdException, IllegalValueTypeException {
        validateCountryInDB(id);
        if (population != null && !population.isEmpty()) {
            validateParseValueToInteger(population);
        }

        return Boolean.toString(new PostgreSQLDAO().updateCountry(id, name, fullname, population, capital));
    }

    @DELETE
    public String deleteCountry(@QueryParam("id") String id) throws IllegalIdException, IllegalValueTypeException {
        validateCountryInDB(id);
        return Boolean.toString(new PostgreSQLDAO().deleteCountry(id));
    }

    private void validateCountryInDB(String id) throws IllegalIdException, IllegalValueTypeException {
        if (getCountries(id, null, null, null, null).isEmpty()) {
            throw new IllegalIdException("Object with id = '" + id + "' not found in DataBase");
        }
    }

    private void validateParseValueToInteger(String value) throws IllegalValueTypeException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalValueTypeException("Can't parse value = '" + value + "' to Integer");
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
