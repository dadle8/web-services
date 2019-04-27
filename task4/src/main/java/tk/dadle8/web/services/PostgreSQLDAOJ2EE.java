package tk.dadle8.web.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAOJ2EE {

    private Connection connection;

    public PostgreSQLDAOJ2EE(Connection connection) {
        this.connection = connection;
    }

    public List<Country> getCountries(String id, String name, String fullname, String population, String capital) {
        List<Country> countries = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(DataBaseUtils.prepareQuery(id, name, fullname, population, capital));
            while (rs.next()) {
                Country country = new Country(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("fullname"),
                        rs.getInt("population"),
                        rs.getString("capital"));
                countries.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }
}
