package businesslogic;

import java.util.Map;

/**
 *
 * @author ugobarbato
 */
public class Availability {
    
    public enum WorkDay { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
                            SATURDAY, SUNDAY }
    
    private Map<WorkDay,String> percentage;
    private Map<WorkDay,String> hour;

    public Map<WorkDay, String> getPercentage() {
        return percentage;
    }

    public Map<WorkDay, String> getHour() {
        return hour;
    }
    
    
}
