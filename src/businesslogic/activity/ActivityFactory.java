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
public class ActivityFactory {

    public enum ActivityType {
        PLANNED,
        EWO,
        EXTRA
    }

    public static MaintenanceActivity getActivity(ActivityType type) {
        if (type == ActivityType.PLANNED) {
            return new PlannedActivity();
        }
        if (type == ActivityType.EWO) {
            return new EWO();
        }
        if (type == ActivityType.EXTRA) {
            return new ExtraActivity();
        }
        return null;
    }

}
