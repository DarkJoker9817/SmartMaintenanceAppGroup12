/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JFrame;

/**
 *
 * @author gioca
 */
public class UserGUIFactory {

    public JFrame getUserGUI(String user) {
        if (user.equals("System Administrator")) {
            return new SysAdminGUI();
        }
        if (user.equals("Planner")) {
            return new PlannerGUI();
        }
        if (user.equals("Maintainer")) {
            return new MaintainerGUI();
        }
        return null;
    }

}
