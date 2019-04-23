package tk.dadle8.web.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    public List<Country> getCountries(String id, String name, String fullname, String population, String capital) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DataBaseUtils.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(DataBaseUtils.prepareSearchQuery(id, name, fullname, population, capital));
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

    public int createCountry(String id, String name, String fullname, String population, String capital) {
        try (Connection connection = DataBaseUtils.getConnection()){
            Statement stmt = connection.createStatement();
            stmt.execute(DataBaseUtils.prepareCreateQuery(id, name, fullname, population, capital));
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getCountries(id, name, fullname, population, capital).get(0).getId();
    }

    public boolean updateCountry(String id, String name, String fullname, String population, String capital) {
        try (Connection connection = DataBaseUtils.getConnection()){
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(DataBaseUtils.prepareUpdateQuery(id, name, fullname, population, capital));
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean deleteCountry(String id) {
        try (Connection connection = DataBaseUtils.getConnection()){
            Statement stmt = connection.createStatement();
            stmt.execute(DataBaseUtils.prepareDeleteQuery(id));
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
