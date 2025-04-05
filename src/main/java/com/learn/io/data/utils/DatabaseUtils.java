package com.learn.io.data.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseUtils {
    private static final String URL = ConfigLoader.get("db.url");
    private static final String USERNAME = ConfigLoader.get("db.username");
    private static final String PASSWORD = ConfigLoader.get("db.password");
    private static final Logger LOGGER = Logger.getLogger(DatabaseUtils.class.getName());
    private static final String EXCEPTION_FORMAT = "exception in %s, message: %s, code: %s";
    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseUtils.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    }catch (SQLException e) {
                        handleSqlException("DatabaseUtils.getConnection", e, LOGGER);
                    }
                }
            }
        }
        return connection;
    }

    public static void handleSqlException(String method, SQLException e, Logger logger) {
        logger.warning(String.format(EXCEPTION_FORMAT, method, e.getMessage(), e.getErrorCode()));
    }

}