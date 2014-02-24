package Structures;

import Tools.AStarInit;

/**
 *
 * A* for finding a route in the generated terrain
 *
 * @author tomminikkanen
 */
public class AStar implements Algorithm {
    
    /**
     * Initializer to be used with AStar
     */ 
    private AStarInit starInitializer;
    /**
     * Array of nodes
     */
    private StarNode[][] nodes;
    /**
     * Heap used for pathfinding
     */
    private MinHeap heap;
    /**
     * Heap used for recording visited nodes
     */
    private MinHeap visited;
    /**
     * Will the visited nodes be recorded? 0=no, 1=yes
     */
    private int record;

    /**
     * Constructs the algorithm
     * @param record visited nodes recorded?
     */
    public AStar(int record) {
        this.starInitializer = new AStarInit();
        this.record = record;
    }

    /**
     *
     * A* relaxation method
     *
     */
    private void relax(StarNode n1, StarNode n2) {
        if (n2.getCostToThisPoint() > n1.getCostToThisPoint() + 1) {
            n2.setCostToThisPoint(n1.getCostToThisPoint() + 1);
            n2.setTotalCost();
            n2.setPrevious(n1);
            heap.insert(n2);
            if (record == 1) {
                visited.insert(n2);
            }
        }
    }

    /**
     * Initializes terrain into nodes
     *
     * @param terrain
     */
    private void initTerrain(int[][] terrain) {
        starInitializer.initTerrainIntoNodes(terrain);
        nodes = starInitializer.getNodes();
    }

    /**
     * Initializes heap to be used with pathfinder
     *
     * @param size
     */
    private void initHeap(int size) {
        heap = new MinHeap(size);
        visited = new MinHeap(size);
        heap.insert(nodes[0][0]);
    }

    /**
     * Helper method to find shortest path
     *
     * @return shortest path
     */
    public double shortestPath() {
        return nodes[nodes.length - 1][nodes[0].length - 1].getTotalCost();
    }

    /**
     * Finds the "best" available route inside terrain
     *
     * @param terrain 
     */
    public void findRoute(int[][] terrain) {
        MinHeap route = new MinHeap(terrain.length*terrain[0].length);
        initTerrain(terrain);
        initHeap(terrain.length * terrain[0].length);
        nodes[0][0].setTotalCost();

        while (!heap.isEmpty()) {
            StarNode current = heap.removeSmallest();
            if (current.getType() == 1) {
                if (current.getY() - 1 >= 0 && nodes[current.getY() - 1][current.getX()].getType() == 1) {
                    relax(current, nodes[current.getY() - 1][current.getX()]);
                }

                if (current.getY() + 1 <= nodes.length - 1 && nodes[current.getY()+1][current.getX()].getType() == 1) {
                    relax(current, nodes[current.getY()+1][current.getX()]);
                }

                if (current.getX() - 1 >= 0 && nodes[current.getY()][current.getX()-1].getType() == 1) {
                    relax(current, nodes[current.getY()][current.getX()-1]);
                }

                if (current.getX() + 1 <= nodes.length - 1 && nodes[current.getY()][current.getX()+1].getType() == 1) {
                    relax(current, nodes[current.getY()][current.getX() + 1]);
                }
            }
        }
    }
    
    /**
     * Returns all the nodes
     * @return
     */
    public Node[][] getNodes() {
        return nodes;
    }
    
    /**
     * Transforms the nodes for visualization
     */
    public void transformForGui() {
        StarNode current;
        while(!visited.isEmpty()) {
            current = visited.removeSmallest();
            current.setType(3);
        }
        nodes[nodes.length-1][nodes[0].length-1].setType(2);
        current = nodes[nodes.length-1][nodes[0].length-1];
        while(current.getPrevious() != null) {
            current.setType(2);
            current = current.getPrevious();
        }
        nodes[0][0].setType(2);
    }
    
}
