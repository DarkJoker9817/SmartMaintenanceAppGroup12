/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 * The class Repository includes all the method to perform on a databse 
 * Singleton pattern
 * @author gioca
 */
public class Repository {

    private static Connection conn;  // the connection to the DataBase
    private static final String URL = "jdbc:postgresql://localhost/smart_maintenance_app"; // url of the DataBase
    private static Repository repository;

    /**
     * The Constructor get the connection to the DataBase
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private Repository() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(URL, "postgres", "password");
    }
    
    /**
     * 
     * @return the istance of the repository object
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Repository getIstance() throws ClassNotFoundException, SQLException {
        if (conn == null || conn.isClosed()) {
            repository = new Repository();
        }
        return repository;
    }
    
    /**
     * Close the connection to the DataBase
     * 
     * @throws SQLException 
     */
    public static void close() throws SQLException {
        conn.close();
    }

    /**
     * Only for select query
     * @param query The query to execute
     * @return The ResultSet of the query
     * @throws SQLException 
     */
    public ResultSet select(String query) throws SQLException {
        ResultSet res;
        try (Statement st = conn.createStatement()) {
            res = st.executeQuery(query);
        }
        return res;
    }
    
    /**
     * Only for update query
     * @param query The query to execute 
     * @return Either the row count for SQL Data Manipulation Language (DML) statements or 
     *         0 for SQL statements that return nothing
     * @throws SQLException 
     */
    public int update(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }
    
    /**
     * Only for delete query
     * @param query The query to execute
     * @return Either the row count for SQL Data Manipulation Language (DML) statements or 
     *         0 for SQL statements that return nothing
     * @throws SQLException 
     */
    public int delete(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }
    
    /**
     * Only for insert query
     * @param query The query to execute
     * @return Either the row count for SQL Data Manipulation Language (DML) statements or 
     *         0 for SQL statements that return nothing
     * @throws SQLException 
     */
    public int insert(String query) throws SQLException {
        int nRow;
        try (Statement st = conn.createStatement()) {
            nRow = st.executeUpdate(query);
        }
        return nRow;
    }

}
