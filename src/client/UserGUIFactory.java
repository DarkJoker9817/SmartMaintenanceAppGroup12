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

    public JFrame getUserGUI(String gui) {
        if (gui.equals("System Administrator")) {
            return new SysAdminGUI();
        }
        if (gui.equals("Planner")) {
            return new PlannerGUI();
        }
        if (gui.equals("Maintainer")) {
            return new MaintainerGUI();
        }
        return null;
    }

}
