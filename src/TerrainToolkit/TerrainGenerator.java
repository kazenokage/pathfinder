package TerrainToolkit;

import java.util.Random;

/**
 *
 * Terrain generator is used to create terran for the search algorithm.
 * 
 * @author tomminikkanen
 */
public class TerrainGenerator {

    private int width;
    private int height;
    private int density;
    private int[][] terrain;
    private Random random;

    /**
     *
     * @param width of the terrain
     * @param height of the terrain
     * @param density
     */
    public TerrainGenerator(int width, int height, int density) {
        this.width = width;
        this.height = height;
        this.density = density;
        random = new Random();
        terrain = new int[width][height];
    }

    /**
     *
     * Generates the terrain, currently randomized.
     *
     */
    public void generateTerrain() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    terrain[i][j] = randomizeTile(); // = 1
                } else {
                    terrain[i][j] = randomizeTile();
                }
            }
        }
    }

    /**
     *
     * Returns a randomized terrain tile
     *
     * @return 0 for an empty tile, 1 for an obstacle
     */
    public int randomizeTile() {
        if (random.nextInt(100) < density) {
            return 1;
        }
        return 0;
    }

    /**
     *
     * @return the terrain
     */
    public int[][] getTerrain() {
        return terrain;
    }
}
