package com.github.kaydunov.dao;

import com.github.kaydunov.exception.DatabaseConfigurationException;

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

    static {
        try {
            PROPERTIES.load(new FileReader("resources/database.properties"));
            String driverName = PROPERTIES.getProperty("db.driver");
            Class.forName(driverName);
        }
        catch (IOException | ClassNotFoundException e) {
            throw new DatabaseConfigurationException("Incorrect database driver", e);
        }
        DATABASE_URL = PROPERTIES.getProperty("db.url");
    }

    private ConnectionCreator()
    {
    }

    public static Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }
}
