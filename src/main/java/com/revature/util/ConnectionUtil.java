package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        String connectionString = "jdbc:postgresql://training-db-0301.cj0whtyhs6u2.us-east-1.rds.amazonaws" +
                ".com:5432/postgres";

        // do not hardcode in your credentials >:(
        // we  set up environment variables which we can access with our Java app
        String username = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        // the driver manager establishes a connection with our db using our credentials and db info
        return DriverManager.getConnection(connectionString, username, password);

    }
}
