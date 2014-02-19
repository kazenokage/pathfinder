package Structures;

import Tools.AStarInit;
import java.util.PriorityQueue;

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
    private PriorityQueue pq;
    int mode;

    /**
     *
     * @param start
     * @param goal
     */
    public AStar(int mode) {
        this.starInitializer = new AStarInit();
        this.mode = mode;
    }

    /**
     *
     * A* relaxation
     *
     */
    private void relax(StarNode n1, StarNode n2) {
        if (n2.getCostToThisPoint() > n1.getCostToThisPoint() + 1) {
            n2.setCostToThisPoint(n1.getCostToThisPoint() + 1);
            n2.setTotalCost();
            heap.insert(n2);
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
        if (mode == 1) {
            printCurrentNodes();
        }
    }

    /**
     * Initializes heap to be used with pathfinder
     *
     * @param size
     */
    private void initHeap(int size) {
        heap = new MinHeap(size);
        heap.insert(nodes[0][0]);
        System.out.println("Initialized heap: "+heap.toString());
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
     * @return
     */
    public void findRoute(int[][] terrain) {
        initTerrain(terrain);
        initHeap(terrain.length * terrain[0].length);
        nodes[0][0].setTotalCost();

        while (!heap.isEmpty()) {
            System.out.println("Current heap: "+heap.toString());
            StarNode current = heap.removeSmallest();
            if (current.getType() == 1) {
                System.out.println(current);
                if ((current.getY() - 1 >= 0) && nodes[current.getY() - 1][current.getX()].getType() == 1) {
                    relax(current, nodes[current.getY() - 1][current.getX()]);
                }

                if (current.getY() + 1 <= nodes.length - 1 && nodes[current.getX()][current.getY() + 1].getType() == 1) {
                    relax(current, nodes[current.getX()][current.getX() + 1]);
                }

                if ((current.getX() - 1 >= 0) && nodes[current.getX() - 1][current.getX()].getType() == 1) {
                    relax(current, nodes[current.getY() - 1][current.getY()]);
                }

                if (current.getX() + 1 <= nodes.length - 1 && nodes[current.getY()][current.getX() + 1].getType() == 1) {
                    relax(current, nodes[current.getY()][current.getX() + 1]);
                }
            }
        }
    }

    public void printCurrentNodes() {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                System.out.print(nodes[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
