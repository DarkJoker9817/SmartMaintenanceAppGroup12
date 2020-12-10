/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.SysAdmin;
import database.Repository;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class SysAdminTest {

    private SysAdmin admin;
    private Repository rep;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        rep = Repository.getIstance();
        rep.delete("delete from \"user\"");
        admin = new SysAdmin();
        admin.createUser("test", "test", "Planner");
    }

    @Test
    public void testUserCreated() throws SQLException, ClassNotFoundException {
        assertEquals(admin.getUsers().size(), 1);
    }

    @Test
    public void testUpdateUser() throws SQLException, ClassNotFoundException {
        admin.updateUser("test", "test", "pwd", "Planner");
        assertEquals(admin.getUsers().size(), 1);
    }

    @Test
    public void testDeleteUser() throws SQLException, ClassNotFoundException {
        admin.deleteUser("test");
        assertEquals(admin.getUsers().size(), 0);
    }

    @After
    public void tearDown() throws SQLException {
        Repository.close();
    }

}
