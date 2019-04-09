package tk.dadle8.web.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;

@WebService(serviceName = "CountryServiceJ2EE")
public class CountryWebServiceJ2EE {

    @Resource(lookup = "jdbc/ifmo_web")
    private DataSource dataSource;

    @WebMethod(operationName = "getCountries")
    public List<Country> getCountries(@WebParam(name = "id") String id,
                                      @WebParam(name = "name") String name,
                                      @WebParam(name = "fullname") String fullname,
                                      @WebParam(name = "population") String population,
                                      @WebParam(name = "capital") String capital) {
        PostgreSQLDAOJ2EE dao = new PostgreSQLDAOJ2EE(getConnection());
        List<Country> countries = dao.getCountries(id, name, fullname, population, capital);
        return countries;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CountryWebServiceJ2EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
