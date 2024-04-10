package com.kaydunov;

import com.kaydunov.dao.ConnectionCreator;

import java.sql.SQLException;

public class FileSystem
{
    public static void main(String[] args) throws SQLException {
        ConnectionCreator connectionCreator = new ConnectionCreator();
        connectionCreator.createConnection();

    }
}
