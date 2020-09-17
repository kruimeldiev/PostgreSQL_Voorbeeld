package org.example.Database;

import java.sql.*;

public class DatabaseHelper {

    public static void ConnectieMaken() {

        try {

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);

            if (conn != null) {
                System.out.println("Connectie gemaakt");
            } else {
                System.out.println("Error bij connectie maken");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
