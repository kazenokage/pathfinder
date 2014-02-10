
package Structures;

import Tools.AStarInit;

/**
 *
 * A* for finding a route in the generated terrain
 * 
 * @author tomminikkanen
 */
public class AStar {
    
    private AStarInit starInitializer;
    private StarNode[][] nodes;
    private MinHeap heap;
    
    /**
     *
     * @param start
     * @param goal
     */
    public AStar() {
        this.starInitializer = new AStarInit();
    }
    
    /**
     * 
     * A* relaxation
     * 
     */
    private void relax(StarNode n1, StarNode n2) {
        if (n2.getCost() > n1.getCost()+1) {
            n2.setCostToThisPoint(n1.getCost()+1);
            n2.setCost();
            heap.insert(n2);
        }
    }
    
    /**
     *
     * @return
     */
    public MinHeap findRoute() {
        return null;
    }
    
    
}
