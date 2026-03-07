package ma.ensa.studentmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static Connection conn;

    private DBConnection() {}

    public static Connection getInstance() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String host = System.getenv("MYSQL_HOST");
                String port = System.getenv("MYSQL_PORT");
                String db   = System.getenv("MYSQL_DATABASE");
                String user = System.getenv("MYSQL_USER");
                String pass = System.getenv("MYSQL_PASSWORD");

                conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false",
                        user,
                        pass
                );
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }


}
