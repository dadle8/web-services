package tk.dadle8.web.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/countries")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource {

    @GET
    public List<Country> getCountries(@QueryParam("id") String id,
                                      @QueryParam("name") String name,
                                      @QueryParam("fullname") String fullname,
                                      @QueryParam("population") String population,
                                      @QueryParam("capital") String capital) {
        return new PostgreSQLDAO().getCountries(id, name, fullname, population, capital);
    }

    @POST
    public String createCountry(@QueryParam("id") String id,
                             @QueryParam("name") String name,
                             @QueryParam("fullname") String fullname,
                             @QueryParam("population") String population,
                             @QueryParam("capital") String capital) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return Integer.toString(dao.createCountry(id, name, fullname, population, capital));
    }

    @PUT
    public String updateCountry(@QueryParam("id") String id,
                                 @QueryParam("name") String name,
                                 @QueryParam("fullname") String fullname,
                                 @QueryParam("population") String population,
                                 @QueryParam("capital") String capital) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return Boolean.toString(dao.updateCountry(id, name, fullname, population, capital));
    }

    @DELETE
    public String deleteCountry(@QueryParam("id") String id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return Boolean.toString(dao.deleteCountry(id));
    }
}