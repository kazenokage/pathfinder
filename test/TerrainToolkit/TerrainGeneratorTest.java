/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TerrainToolkit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomminikkanen
 */
public class TerrainGeneratorTest {
    
    TerrainGenerator tg;
    
    public TerrainGeneratorTest() {
    }
    
    @Before
    public void setUp() {
        tg = new TerrainGenerator(10,10,10);
    }
    
    /**
     * Test if the terrain is right size
     */
    @Test
    public void testGenerateTerrainCreatesTheDefinedTerrain() {
        tg.generateTerrain();
        assertEquals(10,tg.getTerrain().length);
    }

}
