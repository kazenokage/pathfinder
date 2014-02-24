package Tools;

import Structures.StarNode;

/**
 *
 * @author tomminikkanen
 */
public class AStarInit {
    private StarNode[][] nodes;
    
    /**
     * Constructor
     */
    public AStarInit() {
        
    }
    
    /**
     * Transforms given terrain into nodes
     * 
     * @param terrain
     */
    public void initTerrainIntoNodes(int[][] terrain) {
        this.nodes = new StarNode[terrain.length][terrain[0].length];
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                nodes[i][j] = new StarNode(terrain[i][j],j,i);
                nodes[i][j].setCostToThisPoint(Integer.MAX_VALUE/2);
                nodes[i][j].setGuessedCostToGoal(Math.abs((i-terrain.length-1)+(j-terrain.length-1)));
                //nodes[i][j].setGuessedCostToGoal(Math.sqrt((i*i)+(j*j))); implent when diagonal 
            }
        }
        nodes[0][0].setCostToThisPoint(0);
    }
    
    /**
     * Give all the nodes
     * @return
     */
    public StarNode[][] getNodes() {
        return nodes;
    }
}
