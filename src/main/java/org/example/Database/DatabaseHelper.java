package org.example.Database;

import java.sql.*;

public class DatabaseHelper {

    public static void ConnectieMaken() {

        try {

            // Hiermee wordt de driver geladen door het programma
            // Deze stap is niet (meer) verplicht, maar was in Java 1.6 en eerder wel nodig
            Class.forName("org.postgresql.Driver");

            // Aanmaken van de connectie met de database met behulp van de URL, database naam en database password
            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);

            // Testen of de connectie succesvol is
            if (conn != null) {
                System.out.println("Connectie gemaakt");
            } else {
                System.out.println("Error bij connectie maken");
            }

            // Sluiten van de connectie
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void NaamToevoegen(String naamInvoer, String leeftijdInvoer) {

        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);

            String query = "INSERT INTO namen(naam, leeftijd) VALUES ('" + naamInvoer + "', " + leeftijdInvoer + ");";

            Statement stat = conn.createStatement();

            stat.executeUpdate(query);

            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void NamenOphalen() {

        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);

            String query = "SELECT * FROM namen LIMIT 100";

            Statement stat = conn.createStatement();

            ResultSet result = stat.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("naam_id");
                String naam = result.getString("naam");
                Integer leeftijd = result.getInt("leeftijd");
                System.out.println(id + " " + naam + " " + leeftijd);
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
