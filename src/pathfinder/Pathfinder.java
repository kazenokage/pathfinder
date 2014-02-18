/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;

import Structures.AStar;
import TerrainToolkit.TerrainGenerator;

/**
 *
 * @author tomminikkanen
 */
public class Pathfinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TerrainGenerator terrain = new TerrainGenerator(15,15,15);
        terrain.generateTerrain();
        AStar solver = new AStar(1);
        solver.findRoute(terrain.getTerrain());
    }
}
