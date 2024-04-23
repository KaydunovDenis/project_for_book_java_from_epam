package com.kaydunov.dao;

import com.kaydunov.exception.DatabaseConfigurationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final Properties PROPERTIES = new Properties();
    private static final String DATABASE_URL;

    static {
        try {
            PROPERTIES.load(new FileReader("src/main/resources/database.properties"));
            String driverName = PROPERTIES.getProperty("db.driver");
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            throw new DatabaseConfigurationException("Incorrect database driver", e);
        }
        DATABASE_URL = PROPERTIES.getProperty("db.url");
    }

    private ConnectionManager(){}

    private static class SingletonHelper {
        private static final ConnectionManager INSTANCE = new ConnectionManager();
    }

    public static ConnectionManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }
}
