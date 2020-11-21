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
public class LoginValidate {

    private Repository repository;

    public LoginValidate() {
        this.repository = new Repository();
    }

    public boolean validateUser(String username, String password) {
        ResultSet res = repository.select("SELECT * FROM \"user\" WHERE username = " + "\'" + username + "\'");
        String us = "";
        String pwd = "";
        try {
            while (res.next()) {
                us = res.getString("username");
                pwd = res.getString("password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (username.equals(us) && password.equals(pwd)) {
            return true;
        }
        return false;
    }

    public boolean validateSysAdmin(String username, String password) {
        ResultSet res = repository.select("SELECT * FROM sys_admin WHERE username = " + "\'" + username + "\'");
        String us = "";
        String pwd = "";
        try {
            while (res.next()) {
                us = res.getString("username");
                pwd = res.getString("password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (username.equals(us) && password.equals(pwd)) {
            return true;
        }
        return false;
    }

}
