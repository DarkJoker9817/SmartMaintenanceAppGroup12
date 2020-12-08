/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.LoginValidate;
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
public class LoginValidateTest {

    private Repository rep;
    private LoginValidate login;

    @Before
    public void setUp() throws SQLException {
        login = new LoginValidate();
        rep = new Repository();
        rep.insert("insert into \"user\"(username,password,role) values('pippo','abc','Planner')");
        rep.insert("insert into sys_admin(username,password) values('test','test')");
    }

    @Test
    public void testValidUser() throws SQLException {
        assertTrue(login.isValidUser("pippo", "abc", "Planner"));
    }

    @Test
    public void testNotValidUser() throws SQLException {
        assertFalse(login.isValidUser("test", "test", "test"));
    }

    @Test
    public void testValidSysAdmin() throws SQLException {
        assertTrue(login.isValidSysAdmin("test", "test"));
    }

    @Test
    public void testNotValidSysAdmin() throws SQLException {
        assertFalse(login.isValidSysAdmin("t", "t"));
    }

    @After
    public void tearDown() throws SQLException {
        rep.delete("delete from \"user\"");
        rep.delete("delete from sys_admin");
    }

}
