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

    public static String prepareSearchQuery(String id, String name, String fullname, String population, String capital) {
        StringBuilder query = new StringBuilder("select * from country where true ");

        if (id != null && tryParseInt(id)) {
            appendFieldForSearchQuery(query, "id", id);
        }
        if (name != null && !name.isEmpty()) {
            appendFieldForSearchQuery(query, "name", name);
        }
        if (fullname != null && !fullname.isEmpty()) {
            appendFieldForSearchQuery(query, "fullname", fullname);
        }
        if (population != null && tryParseInt(population)) {
            appendFieldForSearchQuery(query, "population", population);
        }
        if (capital != null && !capital.isEmpty()) {
            appendFieldForSearchQuery(query, "capital", capital);
        }

        return query.append(';').toString();
    }

    public static String prepareCreateQuery(String id, String name, String fullname, String population, String capital) {
        StringBuilder query = new StringBuilder("insert into country (");
        StringBuilder queryValues = new StringBuilder("values (");
        boolean started = false;

        if (id != null && tryParseInt(id)) {
            appendFieldForCreateQuery(started, query, queryValues, "id", id);
            started = true;
        }
        if (name != null && !name.isEmpty()) {
            appendFieldForCreateQuery(started, query, queryValues, "name", name);
            started = true;
        }
        if (fullname != null && !fullname.isEmpty()) {
            appendFieldForCreateQuery(started, query, queryValues, "fullname", fullname);
            started = true;
        }
        if (population != null && tryParseInt(population)) {
            appendFieldForCreateQuery(started, query, queryValues, "population", population);
            started = true;
        }
        if (capital != null && !capital.isEmpty()) {
            appendFieldForCreateQuery(started, query, queryValues, "capital", capital);
        }

        query.append(')');
        queryValues.append(')');

        return query.append(queryValues).append(';').toString();
    }

    public static String prepareUpdateQuery(String id, String name, String fullname, String population, String capital) {
        StringBuilder query = new StringBuilder("update country set ");
        boolean started = false;

        if (name != null && !name.isEmpty()) {
            appendFieldForUpdateQuery(started, query, "name", name);
            started = true;
        }

        if (fullname != null && !fullname.isEmpty()) {
            appendFieldForUpdateQuery(started, query, "fullname", fullname);
            started = true;
        }

        if (population != null && tryParseInt(population)) {
            appendFieldForUpdateQuery(started, query, "population", population);
            started = true;
        }

        if (capital != null && !capital.isEmpty()) {
            appendFieldForUpdateQuery(started, query, "capital", capital);
        }

        return query.append("where id = '").append(id).append('\'').append(';').toString();
    }

    public static String prepareDeleteQuery(String id) {
        return "delete from country where id = '" + id + "';";
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void appendFieldForCreateQuery(boolean started, StringBuilder query, StringBuilder queryValues, String fieldName, String fieldValue) {
        if (started) {
            query.append(',');
            queryValues.append(',');
        }
        query.append(fieldName);
        queryValues.append('\'');
        queryValues.append(fieldValue);
        queryValues.append('\'');
    }

    private static void appendFieldForSearchQuery(StringBuilder query, String fieldName, String fieldValue) {
        query.append("AND ").append(fieldName).append(" = '").append(fieldValue).append("'");
    }

    private static void appendFieldForUpdateQuery(boolean started, StringBuilder query, String fieldName, String fieldValue) {
        if (started) {
            query.append(',');
        }
        query.append(fieldName).append(" = '").append(fieldValue).append("'");
    }
}