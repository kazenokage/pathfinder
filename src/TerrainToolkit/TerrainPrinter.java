
package TerrainToolkit;


public class TerrainPrinter {
    
    String chars;
    
    public TerrainPrinter(char... definedChars) {
        chars = "";
        for (char c : definedChars) {
            this.chars += c;
        }
    }
    
    public void printTerrain(int[][] terrain) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                System.out.print(chars.charAt(terrain[i][j]));
            }
            System.out.print("\n");
        }
    }
}
