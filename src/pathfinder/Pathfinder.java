/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;

import Structures.AStar;
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
        TerrainGenerator terrain = new TerrainGenerator(50,50,15);
        //TerrainPrinter tp = new TerrainPrinter('x','.');
        terrain.generateTerrain();
        //tp.printTerrain(terrain.getTerrain());
        AStar solver = new AStar(0);
        solver.findRoute(terrain.getTerrain());
        //System.out.println(solver.shortestPath());
        GuiController gui = new GuiController(solver);
        gui.showGUI();
    }
}
