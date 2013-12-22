
package TerrainToolkit;

/**
 *
 * Prints the terrain for debugging.
 * 
 * @author tomminikkanen
 */
public class TerrainPrinter {
    
    String chars;
    
    /**
     * 
     * @param definedChars Define the symbols to be used on the terrain
     */
    public TerrainPrinter(char... definedChars) {
        chars = "";
        for (char c : definedChars) {
            this.chars += c;
        }
    }
    
    /**
     *
     * Prints the given terrain using the defined symbols
     * 
     * @param terrain
     */
    public void printTerrain(int[][] terrain) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                System.out.print(chars.charAt(terrain[i][j]));
            }
            System.out.print("\n");
        }
    }
}
