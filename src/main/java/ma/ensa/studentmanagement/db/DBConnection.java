package ma.ensa.studentmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static Connection conn;

    private DBConnection() {}

    public static Connection getInstance() {
        if (conn == null) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/studentmanagement?useSSL=false",
                        "root",
                        "");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }


}
