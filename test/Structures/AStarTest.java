/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import TerrainToolkit.TerrainGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomminikkanen
 */
public class AStarTest {
    
    AStar astar;
    TerrainGenerator tg;
    StarNode n1;
    StarNode n2;
    
    public AStarTest() {
    }
    
    @Before
    public void setUp() {
        astar = new AStar(1);
        tg = new TerrainGenerator(10,10,10);
        n1 = new StarNode(1,1,1);
        n2 = new StarNode(1,2,2);
    }

    @Test
    public void testFindRouteIfSolveable() {
        tg.generateTerrain();
        if (tg.getTerrain()[0][0] == 1 && tg.getTerrain()[tg.getTerrain().length-1][tg.getTerrain()[0].length-1] == 1) {
            astar.findRoute(tg.getTerrain());
            boolean test = false;
            if (astar.shortestPath() > 0) {
                test = true;
            }
            assertEquals(true,test);
        }
    }

}
