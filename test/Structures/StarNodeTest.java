/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomminikkanen
 */
public class StarNodeTest {
    
    StarNode n;
    StarNode m;
    
    public StarNodeTest() {  
    }
    
    @Before
    public void setUp() {
        n = new StarNode(1,1,1);
        m = new StarNode(1,3,4);
    }

    
    /**
     * Test if the cost is calculated correctly
     */
    @Test
    public void testGetCost() {
        n.setCostToThisPoint(5);
        n.setGuessedCostToGoal(8);
        n.setCost();
        assertEquals(13,n.getCost(),0.1);
    }
}
