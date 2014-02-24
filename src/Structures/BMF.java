package Structures;

import Tools.BMFInit;

public class BMF implements Algorithm {

    private BMFNode[][] nodes;
    private MinHeap visited;

    public BMF() {
    }

    public void findRoute(int[][] terrain) {
        BMFInit init = new BMFInit();
        nodes = init.initialize(terrain);

        for (int k = 0; k < nodes.length; k++) {
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes[0].length; j++) {
                    if (nodes[i][j].getType() == 1) {
                        if (i - 1 >= 0 && nodes[i - 1][j].getType() == 1) {
                            relax(nodes[i][j], nodes[i - 1][j]);
                        }
                        if (i + 1 <= nodes.length - 1 && nodes[i + 1][j].getType() == 1) {
                            relax(nodes[i][j], nodes[i + 1][j]);
                        }
                        if (j - 1 >= 0 && nodes[i][j - 1].getType() == 1) {
                            relax(nodes[i][j], nodes[i][j - 1]);
                        }
                        if (j + 1 <= nodes[0].length - 1 && nodes[i][j + 1].getType() == 1) {
                            relax(nodes[i][j], nodes[i][j + 1]);
                        }
                    }
                }
            }
        }
    }

    private void relax(BMFNode n1, BMFNode n2) {
        if (n2.getCostToThisPoint() > n1.getCostToThisPoint() + 1) {
            n2.setCostToThisPoint(n1.getCostToThisPoint() + 1);
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public int getShortestPath() {
        return nodes[nodes.length - 1][nodes[0].length - 1].getCostToThisPoint();
    }

}
