package jdbc.example_1.src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class SimpleJdbcMain
{

    private static final String URL = "jdbc:h2:/Users/leverx/IdeaProjects/project_for_book_java_from_epam/src/jdbc/example_1_v1/db/testphones";
    private static final Properties PROP = new Properties();

    private static final Logger logger = Logger.getLogger("LOG");
    private static final Driver DRIVER = new org.h2.Driver();

    static {
        PROP.put("user", "root");
        PROP.put("password", "pass");
        PROP.put("autoReconnect", " true ");
        PROP.put(" characterEncoding ", " UTF - 8 ");
        PROP.put(" useUnicode ", " true ");
        PROP.put("useSSL", "true");
        PROP.put("useJDBCCompliantTimezoneShift", "true");
        PROP.put("useLegacyDatetimeCode", "false");
        PROP.put("serverTimezone", "UTC");
        PROP.put("serverSslCert", "classpath:server.crt");
    }

    public static void main(String[] args)
    {
        registerDriver();
        run();
    }

    private static void run()
    {
        try (Connection connection = DriverManager.getConnection(URL, PROP);
            Statement statement = connection.createStatement()) {
            String sql = "SELECT idphonebook, lastname, phone FROM PHONEBOOK";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Abonent> abonents = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int number = resultSet.getInt("phone");
                abonents.add(new Abonent(id, name, number));
            }
            logger.info(abonents.toString());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registerDriver()
    {
        try {
            DriverManager.registerDriver(DRIVER);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}