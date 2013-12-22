
package Structures;

/**
 *
 * A* for finding a route in the generated terrain
 * 
 * @author tomminikkanen
 */
public class AStar {
    
    StarNode startNode;
    StarNode goalNode;
    
    StarNode[] closedNodes;
    StarNode[] openNodes;
    
    /**
     *
     * @param start
     * @param goal
     */
    public AStar(StarNode start, StarNode goal) {
        this.startNode = start;
        this.goalNode = goal;
    }
    
    /**
     * 
     * A* relaxation
     * 
     */
    private void relax() {
        
    }
    
    /**
     *
     * @return
     */
    public MinHeap findRoute() {
        return null;
    }
    
    
}
