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
    public void setUp() {
        rep = new Repository();
    }

    @Test
    public void testSelectNullPointer() throws SQLException {
        assertNull(rep.select(""));
    }

    @Test
    public void testSelectResultSet() throws SQLException {
        assertNotNull(rep.select("select * from \"user\""));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
