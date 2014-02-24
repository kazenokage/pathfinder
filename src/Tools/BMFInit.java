package Tools;

import Structures.BMFNode;

public class BMFInit {
    
    private BMFNode[][] nodes;
    
    public BMFInit() {
        
    }
    
    public BMFNode[][] initialize(int[][] terrain) {
        nodes = new BMFNode[terrain.length][terrain[0].length];
        
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                this.nodes[i][j] = new BMFNode(terrain[i][j]);
                this.nodes[i][j].setCostToThisPoint(Integer.MAX_VALUE/2);
            }
        }
        nodes[0][0].setCostToThisPoint(0);
        return nodes;
    }
    
}
