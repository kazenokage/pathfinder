/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;

import Structures.AStar;
import Structures.BMF;
import Structures.Dijkstra;
import TerrainToolkit.TerrainGenerator;
import gui.GuiController;

/**
 *
 * @author tomminikkanen
 */
public class Pathfinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TerrainGenerator terrain = new TerrainGenerator(60,60,10);
        terrain.generateTerrain();
        
        AStar solver = new AStar(0);
        solver.findRoute(terrain.getTerrain());
        solver.transformForGui();
        System.out.println("[A*] Shortest path length: "+solver.shortestPath());
        
        BMF solver2 = new BMF();
        solver2.findRoute(terrain.getTerrain());
        System.out.println("[BMF] Shortest path length: "+solver2.getShortestPath());
        
        Dijkstra solver3 = new Dijkstra();
        solver3.findRoute(terrain.getTerrain());
        System.out.println("[Dijkstra] Shortest path length: "+solver2.getShortestPath());
        
        GuiController gui = new GuiController(solver,"A*");
        gui.showGUI();

    }
}
