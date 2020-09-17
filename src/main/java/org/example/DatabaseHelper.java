package org.example;

import java.sql.*;

public class DatabaseHelper {

    Connection conn = null;

    public DatabaseHelper() {

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(DataKeys.CONN_URL);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
