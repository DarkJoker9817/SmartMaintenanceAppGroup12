/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogic.activity.*;

/**
 *
 * @author ugobarbato
 */
public class prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Planner planner = new Planner("pippo", "pippo");
    
    planner.createActivity(1, null, 3, null, MaintenanceType.HYDRAULIC, "prova", 60, true, "sdskdgjnksdg", null);
    System.out.println(planner.getActivity(1).toString());
    planner.modifyActivity(1, null, 5, null, MaintenanceType.MECHANICAL, "prova2", 90, true, "skfnglsfngl", null);
    System.out.println(planner.getActivity(1).toString());
    }
    
}
