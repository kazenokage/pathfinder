/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinder;

import TerrainToolkit.TerrainGenerator;
import TerrainToolkit.TerrainPrinter;

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
        TerrainPrinter printer = new TerrainPrinter('.','█');
        terrain.generateTerrain();
        printer.printTerrain(terrain.getTerrain());
    }
}
