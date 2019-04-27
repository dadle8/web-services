package tk.dadle8.web.services.j2ee;

import tk.dadle8.web.services.Country;
import tk.dadle8.web.services.PostgreSQLDAOJ2EE;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/countriesj2ee")
@Produces({MediaType.APPLICATION_JSON})
public class CountryResourceJ2EE {

    @Resource(lookup = "jdbc/ifmo_web")
    private DataSource dataSource;

    @GET
    public List<Country> getCountries(@QueryParam("id") String id,
                                      @QueryParam("name") String name,
                                      @QueryParam("fullname") String fullname,
                                      @QueryParam("population") String population,
                                      @QueryParam("capital") String capital) {
        return new PostgreSQLDAOJ2EE(getConnection()).getCountries(id, name, fullname, population, capital);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CountryResourceJ2EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
