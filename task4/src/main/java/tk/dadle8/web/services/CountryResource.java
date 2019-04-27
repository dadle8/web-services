package tk.dadle8.web.services;

import java.util.List;
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
}