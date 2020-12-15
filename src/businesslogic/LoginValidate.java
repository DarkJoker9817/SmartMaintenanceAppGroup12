/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import database.Repository;
import java.sql.*;

/**
 *
 * @author gioca
 */
public class LoginValidate {

    private Repository repository;
    
    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public LoginValidate() throws ClassNotFoundException, SQLException {
        this.repository = Repository.getIstance();
    }

    /**
     * 
     * @param username a String representing the username of the user
     * @param password a String representing the password of the user
     * @param role a String representing the role of the user
     * @return true if username and password are associated to a user 
     *         in the database, otherwise return false
     * @throws SQLException 
     */
    public boolean isValidUser(String username, String password, String role) throws SQLException {
        String us = "";
        String pwd = "";
        String rl = "";
        try (ResultSet res = repository.select("SELECT * FROM \"user\" WHERE username = " + "\'" + username + "\'")) {
            while (res.next()) {
                us = res.getString("username");
                pwd = res.getString("password");
                rl = res.getString("role");
            }
        }
        if (username.equals(us) && password.equals(pwd) && role.equals(rl)) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param username a String representing the username of the System Administrator
     * @param password a String representing the password of the System Administrator
     * @return true if username and password are associated to the system administrator
     *         in the database, otherwise return false
     * @throws SQLException 
     */
    public boolean isValidSysAdmin(String username, String password) throws SQLException {
        String us = "";
        String pwd = "";
        try (ResultSet res = repository.select("SELECT * FROM sys_admin WHERE username = " + "\'" + username + "\'")) {
            while (res.next()) {
                us = res.getString("username");
                pwd = res.getString("password");
            }
        }
        if (username.equals(us) && password.equals(pwd)) {
            return true;
        }
        return false;
    }

}
