/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.UserGUIFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class UserGUIFactoryTest {

    UserGUIFactory gui;

    @Before
    public void setUp() {
        gui = new UserGUIFactory();
    }

    @Test
    public void notNullJFrame() {
        assertNotNull(gui.getUserGUI("System Administrator"));
        assertNotNull(gui.getUserGUI("Planner"));
        assertNotNull(gui.getUserGUI("Maintainer"));

    }

    @Test
    public void nullJFrame() {
        assertNull(gui.getUserGUI(""));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
