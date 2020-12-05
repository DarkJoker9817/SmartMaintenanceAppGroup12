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

    private Connection conn;  // the connection to the DataBase
    private String url = "jdbc:postgresql://localhost/smart_maintenance_app"; // url of the DataBase

    public Repository() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }

    /*
     * 
     * 
     */
    public ResultSet select(String query) throws SQLException {
        ResultSet res;
        try (Statement st = conn.createStatement()) {
            res = st.executeQuery(query);
        }
        return res;
    }

    public int update(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }

    public int delete(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }

    public int insert(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }

}
