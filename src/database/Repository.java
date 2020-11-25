/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author gioca
 */
public class Repository {

    private Connection conn;
    private String url = "jdbc:postgresql://localhost/smart_maintenance_app"; // nome del DataBase

    public Repository() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, "postgres", "password");
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }

    public ResultSet select(String query) throws SQLException {
        ResultSet res;
        try (Statement st = conn.createStatement()) {
            res = st.executeQuery(query);
        }
        return res;
    }

    public void update(String query) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(query);
        }

    }

    public void delete(String query) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(query);
        }

    }

    public void insert(String query) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(query);
        } 

    }

}
