package jdbc_g13.example_6.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator
{
    private static final Properties PROPERTIES = new Properties();
    private static final String DATABASE_URL;

    private ConnectionCreator(){}

    static {
        try {
            PROPERTIES.load(new FileReader("src/jdbc/example_6/database.properties"));
            String driverName = PROPERTIES.getProperty("db.driver");
            Class.forName(driverName);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        DATABASE_URL = PROPERTIES.getProperty("db.url");
    }

    public static Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }
}
