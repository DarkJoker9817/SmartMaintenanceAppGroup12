/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.activity.ActivityFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class ActivityFactoryTest {
    
    @Test
    public void getPlannedActivity() {
        assertNotNull(ActivityFactory.getActivity(ActivityFactory.ActivityType.PLANNED));
    }
    
    @Test
    public void getUnplannedActivity() {
        assertNotNull(ActivityFactory.getActivity(ActivityFactory.ActivityType.EWO));
        assertNotNull(ActivityFactory.getActivity(ActivityFactory.ActivityType.EXTRA));
    }
    
    @Test
    public void getNullActivity() {
        assertNull(ActivityFactory.getActivity(null));
    }
    
}
