/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author gioca
 */
public class GUIFactory {

    public static JFrame getGUI(String gui) throws ClassNotFoundException, SQLException {
        if (gui.equals("System Administrator")) {
            return new SysAdminGUI();
        }
        if (gui.equals("Planner")) {
            return new PlannerGUI();
        }
        if (gui.equals("Maintainer")) {
            return new MaintainerGUI();
        }
        if (gui.equals("Login")) {
            return new LoginGUI();
        }

        return null;
    }

}
