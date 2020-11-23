/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import smartmaintenanceappgroup12.Repository;

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
    public void testNullPointer() {
        assertNull(rep.delete(""));
        assertNull(rep.select(""));
        assertNull(rep.insert(""));
        assertNull(rep.update(""));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
