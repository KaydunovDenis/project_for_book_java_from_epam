package jdbc_g13.example_2_5;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorCreator
{
    private static final Properties PROPERTIES = new Properties();
    private static final String DATABASE_URL;

    private ConnectorCreator(){}

    static {
        try {
            PROPERTIES.load(new FileReader("src/jdbc/example_1_v2/database.properties"));
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
