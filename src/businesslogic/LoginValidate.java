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

    public LoginValidate() {
        this.repository = new Repository();
    }

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
