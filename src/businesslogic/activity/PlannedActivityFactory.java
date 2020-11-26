/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.activity;

/**
 *
 * @author gioca
 */
public class PlannedActivityFactory extends ActivityFactory {

    @Override
    protected MaintenanceActivity selectActivity(CategoryUnplanned unplanned) {
        return new PlannedActivity();

    }

}
