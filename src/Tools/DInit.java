package Tools;

import Structures.DNode;

/**
 *
 * @author tomminikkanen
 */
public class DInit {

    /**
     *
     */
    public DInit() {
    }

    /**
     *
     * @param terrain
     * @return
     */
    public DNode[][] init(int[][] terrain) {
        DNode[][] nodes = new DNode[terrain.length][terrain[0].length];

        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                nodes[i][j] = new DNode(terrain[i][j], j, i);
                nodes[i][j].setCostToThisPoint(Integer.MAX_VALUE / 2);
            }
        }
        nodes[0][0].setCostToThisPoint(0);
        
        return nodes;
    }
}
