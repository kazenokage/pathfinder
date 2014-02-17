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
public class MinHeapTest {
    
    MinHeap testHeap;
    StarNode nodeA;
    StarNode nodeB;
    StarNode nodeC;
    StarNode nodeD;
    StarNode nodeE;
    
    public MinHeapTest() {
    }
    
    @Before
    public void setUp() {
        testHeap = new MinHeap(5);
        nodeA = new StarNode(1,0,0);
        nodeB = new StarNode(1,4,7);
        nodeC = new StarNode(2,3,6);
        nodeD = new StarNode(2,5,9);
        nodeE = new StarNode(2,0,3);
    }

    @Test
    public void singleInsertionWorks() {
        testHeap.insert(nodeA);
        assertEquals("0,0", testHeap.removeSmallest().toString());
    }
    
    @Test
    public void multipleInsertionsWork() {
        testHeap.insert(nodeA);
        testHeap.insert(nodeB);
        testHeap.insert(nodeC);
        assertEquals("0,0", testHeap.removeSmallest().toString());
        assertEquals("3,6", testHeap.removeSmallest().toString());
        assertEquals("4,7", testHeap.removeSmallest().toString());
    }
    
    @Test 
    public void heapStaysIntactAfterSomeFiddling() {
        testHeap.insert(nodeA);
        testHeap.insert(nodeB);
        testHeap.insert(nodeC);
        testHeap.removeSmallest();
        nodeA.setCostToThisPoint(5);
        nodeA.setGuessedCostToGoal(8);
        testHeap.insert(nodeA);
        assertEquals("3,6", testHeap.removeSmallest().toString());
    }
    
    @Test
    public void emptyIfNoNodes() {
        assertEquals(true, testHeap.isEmpty());
    }
    
    @Test 
    public void notEmptyIfSomeNodes() {
        testHeap.insert(nodeA);
        assertEquals(false, testHeap.isEmpty());
    }
    
    @Test 
    public void emptyAfterRemovingNodes() {
        testHeap.insert(nodeA);
        testHeap.removeSmallest();
        assertEquals(true, testHeap.isEmpty());
    }

}
