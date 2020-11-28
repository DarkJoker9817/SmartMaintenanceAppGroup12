/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.Repository;
import java.sql.SQLException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class RepositoryTest {

    private Repository rep;

    @Before
    public void setUpDatabase() throws SQLException {
        rep = new Repository();
        rep.insert("insert into \"user\"(username,password,role) values('test','abc','Planner')");
    }

    @Test
    public void testSelectResultSet() throws SQLException {
        assertNotNull(rep.select("select * from \"user\""));
    }

    @Test
    public void deleteRow() throws SQLException {
        assertEquals(rep.delete("delete from \"user\" where username = 'test'"), 1);
    }

    @Test
    public void insertRow() throws SQLException {
        assertEquals(rep.insert("insert into \"user\"(username,password,role) values('prova','abc','Planner')"), 1);
    }

    @Test
    public void updateRow() throws SQLException {
        assertEquals(rep.update("update \"user\" set username = 'Test' where username = 'test'"), 1);
    }

    @After
    public void tearDownDatabase() throws SQLException {
        rep.delete("delete from \"user\"");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
