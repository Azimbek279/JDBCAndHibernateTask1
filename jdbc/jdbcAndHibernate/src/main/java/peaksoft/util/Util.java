package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String url = "jdbc:postgresql://localhost:5432/home5";
    public static final String username = "postgres";
    public static final String password = "1234";

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
        // реализуйте настройку соеденения с БД
}

