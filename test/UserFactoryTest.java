/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.UserFactory;
import database.Repository;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class UserFactoryTest {

    @Test
    public void testNotNullUser() throws ClassNotFoundException, SQLException {
        assertNotNull(UserFactory.getUser("Planner"));
        assertNotNull(UserFactory.getUser("Maintainer"));
    }

    @Test
    public void testNullUser() throws ClassNotFoundException, SQLException {
        assertNull(UserFactory.getUser(""));
    }

    @After
    public void tearDown() throws SQLException {
        Repository.close();
    }

}
