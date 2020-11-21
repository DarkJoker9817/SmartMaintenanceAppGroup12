/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmaintenanceappgroup12;

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
            this.conn = DriverManager.getConnection(url, "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        ResultSet res = null;
        try {
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public ResultSet update(String query) {
        ResultSet res = null;
        try {
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public ResultSet delete(String query) {
        ResultSet res = null;
        try {
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public ResultSet insert(String query) {
        ResultSet res = null;
        try {
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
