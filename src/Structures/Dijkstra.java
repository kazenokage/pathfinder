
package Structures;

import Tools.DInit;


public class Dijkstra implements Algorithm {
    
    private DInit DInitializer;
    private DNode[][] nodes;
    private MinHeapD heap;
    private MinHeapD visited;

    /**
     *
     * @param start
     * @param goal
     */
    public Dijkstra() {
       DInitializer = new DInit();
    }

    /**
     *
     * A* relaxation
     *
     */
    private void relax(DNode n1, DNode n2) {
        if (n2.getCostToThisPoint() > n1.getCostToThisPoint() + 1) {
            n2.setCostToThisPoint(n1.getCostToThisPoint() + 1);
            n2.setPrevious(n1);
            heap.insert(n2);
            visited.insert(n2);
        }
    }

    /**
     * Initializes terrain into nodes
     *
     * @param terrain
     */
    private void initTerrain(int[][] terrain) {
        nodes = DInitializer.init(terrain);
    }

    /**
     * Initializes heap to be used with pathfinder
     *
     * @param size
     */
    private void initHeap(int size) {
        heap = new MinHeapD(size);
        visited = new MinHeapD(size);
        heap.insert(nodes[0][0]);
    }

    /**
     * Helper method to find shortest path
     *
     * @return shortest path
     */
    public double shortestPath() {
        return nodes[nodes.length - 1][nodes[0].length - 1].getCostToThisPoint();
    }

    /**
     * Finds the "best" available route inside terrain
     *
     * @return
     */
    public void findRoute(int[][] terrain) {
        initTerrain(terrain);
        initHeap(terrain.length * terrain[0].length);

        while (!heap.isEmpty()) {
            DNode current = heap.removeSmallest();
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

    public void printCurrentNodes() {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                System.out.print(nodes[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    @Override
    public Node[][] getNodes() {
        return nodes;
    }
    
    public void transformForGui() {
        DNode current;
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
