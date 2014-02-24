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

    static AStar solver = new AStar(1);
    static BMF solver2 = new BMF();
    static Dijkstra solver3 = new Dijkstra(1);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TerrainGenerator terrain = new TerrainGenerator(100, 100, 10);
        terrain.generateTerrain();
        
        double time1;
        double time2;

        time1 = System.currentTimeMillis();
        solver.findRoute(terrain.getTerrain());
        time2 = System.currentTimeMillis();
        System.out.println("[A*] Shortest path length: " + solver.shortestPath());
        System.out.println("[A*] "+(time2-time1)+" ms");
        solver.transformForGui();


        time1 = System.currentTimeMillis();
        solver2.findRoute(terrain.getTerrain());
        time2 = System.currentTimeMillis();
        System.out.println("[BMF] Shortest path length: " + solver2.getShortestPath());
        System.out.println("[BMF] "+(time2-time1)+" ms");


        time1 = System.currentTimeMillis();
        solver3.findRoute(terrain.getTerrain());
        time2 = System.currentTimeMillis();
        System.out.println("[Dijkstra] Shortest path length: " + solver2.getShortestPath());
        System.out.println("[Dijkstra] "+(time2-time1)+" ms");
        solver3.transformForGui();

        GuiController gui = new GuiController(solver, "A*");
        gui.showGUI();

    }
}
