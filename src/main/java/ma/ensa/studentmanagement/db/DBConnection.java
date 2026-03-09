package ma.ensa.studentmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConnection {
    private static Connection conn;

    private DBConnection() {}

    public static void initDB() {
        try {
            Statement st = getInstance().createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS student (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "email VARCHAR(100)," +
                    "birthday DATE)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getInstance() {
//        if (conn == null) {
            try {
                if (conn == null || !conn.isClosed()) {
                    Class.forName("com.mysql.cj.jdbc.Driver");

//                String host = System.getenv("MYSQL_HOST");
//                String port = System.getenv("MYSQL_PORT");
//                String db   = System.getenv("MYSQL_DATABASE");
//                String user = System.getenv("MYSQL_USER");
//                String pass = System.getenv("MYSQL_PASSWORD");

                    conn = DriverManager.getConnection(
                            "jdbc:mysql://nozomi.proxy.rlwy.net:56838/railway?useSSL=false&allowPublicKeyRetrieval=true",
                            "root",
                            "SYmxlnrecAUKFBxfYBfmdCmDkFRVjRvt"
                    );
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
//        }
        return conn;
    }


}
