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
        rep.insert("insert into sys_admin(username,password) values('admin','admin')");
    }

    @Test
    public void validUser() throws SQLException {
        assertTrue(login.isValidUser("pippo", "abc", "Planner"));
    }

    @Test
    public void notValidUser() throws SQLException {
        assertFalse(login.isValidUser("test", "test", "test"));
    }

    @Test
    public void validSysAdmin() throws SQLException {
        assertTrue(login.isValidSysAdmin("admin", "admin"));
    }

    @Test
    public void notValidSysAdmin() throws SQLException {
        assertFalse(login.isValidSysAdmin("test", "test"));
    }

    @After
    public void tearDown() throws SQLException {
        rep.delete("delete from \"user\"");
        rep.delete("delete from sys_admin");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
