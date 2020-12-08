/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUIFactory;
import database.Repository;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class UserGUIFactoryTest {

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        Repository.connect();
    }

    @Test
    public void testNotNullJFrame() {
        assertNotNull(GUIFactory.getGUI("System Administrator"));
        assertNotNull(GUIFactory.getGUI("Planner"));
        assertNotNull(GUIFactory.getGUI("Maintainer"));
        assertNotNull(GUIFactory.getGUI("Login"));
    }

    @Test
    public void testNullJFrame() {
        assertNull(GUIFactory.getGUI(""));
    }

    @After
    public void tearDown() throws SQLException {
        Repository.close();
    }

}
