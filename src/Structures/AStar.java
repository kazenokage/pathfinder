
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
    
    private void initTerrain(int[][] terrain) {
        starInitializer.initTerrainIntoNodes(terrain);
        nodes = starInitializer.getNodes();
    }
    
    private void initHeap(int size) {
        heap = new MinHeap(size);
        heap.insert(nodes[0][0]);
    }
    
    public float shortestPath() {
        return nodes[nodes.length-1][nodes[0].length-1].getCost();
    }
    
    /**
     *
     * @return
     */
    public void findRoute(int[][] terrain) {
        initTerrain(terrain);
        initHeap(terrain.length*terrain[0].length);
        nodes[0][0].setCost();
        
        while (!heap.isEmpty()) {
            StarNode current = heap.removeSmallest();
            // need to rebuild this
        }
    }
    
    
}
