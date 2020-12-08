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

    private static Connection conn;  // the connection to the DataBase
    private static final String URL = "jdbc:postgresql://localhost/SmartMaintenanceApp"; // url of the DataBase

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(URL, "postgres", "password");
    }

    public static void close() throws SQLException {
        conn.close();
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
