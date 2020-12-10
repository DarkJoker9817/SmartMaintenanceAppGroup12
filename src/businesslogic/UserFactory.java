/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.sql.SQLException;

/**
 *
 * @author ugobarbato
 */
public class UserFactory {
    
    public static User getUser(String role) throws ClassNotFoundException, SQLException {
        if (role.equals("Planner")) {
            return new Planner();
        }
        if (role.equals("Maintainer")) {
            return new Maintainer();
        }
        return null;
    }
}
