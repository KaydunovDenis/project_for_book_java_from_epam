package com.kaydunov.dao;

import com.kaydunov.exception.DatabaseConfigurationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }

    public Statement getStatement() throws SQLException {
        return this.createConnection().createStatement();
    }
}
