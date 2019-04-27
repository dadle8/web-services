package tk.dadle8.web.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseUtils {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ifmo_web";
    private static final String JDBC_USER = "ifmo";
    private static final String JDBC_PASSWORD = "ifmo";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static String prepareQuery(String id, String name, String fullname, String population, String capital) {
        StringBuilder query = new StringBuilder("select * from country where true ");

        if (id != null && tryParseInt(id)) {
            query.append("AND id = '").append(id).append("'");
        }
        if (name != null && !name.isEmpty()) {
            query.append("AND name = '").append(name).append("'");
        }
        if (fullname != null && !fullname.isEmpty()) {
            query.append("AND fullname = '").append(fullname).append("'");
        }
        if (population != null && tryParseInt(population)) {
            query.append("AND population = '").append(population).append("'");
        }
        if (capital != null && !capital.isEmpty()) {
            query.append("AND capital = '").append(capital).append("'");
        }

        return query.append(';').toString();
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}