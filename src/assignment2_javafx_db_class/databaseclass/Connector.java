package assignment2_javafx_db_class.databaseclass;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private final static String connectionString = "jdbc:mysql://localhost:3306/classlist";
    private final static String user = "root";
    private final static String pwd = "";// xampp: ""  mamp: "root"
    private final Connection conn;
    // singleton patterns
    private static Connector instance;

    public Connector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(connectionString, user, pwd);
    }
    public static Connector getInstance() throws Exception {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }
}
