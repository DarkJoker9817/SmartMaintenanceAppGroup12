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
public abstract class ActivityFactory {

    public enum Category {
        PLANNED,
        UNPLANNED
    }

    public enum CategoryUnplanned {
        EWO,
        EXTRA
    }

    public static MaintenanceActivity make(Category c, CategoryUnplanned unplanned) {
        ActivityFactory factory = null;
        if (c == Category.PLANNED) {
            factory = new PlannedActivityFactory();
        } else {
            factory = new UnplannedActivityFactory();
        }
        return factory.selectActivity(unplanned);
    }

    protected abstract MaintenanceActivity selectActivity(CategoryUnplanned unplanned);

}
