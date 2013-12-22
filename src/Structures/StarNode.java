
package Structures;

/**
 *
 * Node for A* algo
 * 
 * @author tomminikkanen
 */
public class StarNode {
    private int type;
    private int x;
    private int y;
    
    private float cost;
    private float costToThisPoint;
    private float guessedCostToGoal;
    
    /**
     *
     * @param type type of the node (=tile)
     * @param x -coordinate
     * @param y -coordinate
     */
    public StarNode(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.cost = 0;
        this.costToThisPoint = 0;
        this.guessedCostToGoal = 0;
    }
    
    /**
     *
     * @return x-coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     *
     * @return y-coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     *
     * @param c the cost to be set
     */
    public void setCostToThisPoint(float c) {
        this.costToThisPoint = c;
    }
    
    /**
     *
     * @param g guess to be set
     */
    public void setGuessedCostToGoal(float g) {
        this.guessedCostToGoal = g;
    }
    
    /**
     *
     * Will set the total cost based on the current cost and the guess.
     * 
     */
    public void setCost() {
        cost = costToThisPoint + guessedCostToGoal;
    }
    
    /**
     *
     * @return total cost
     */
    public float getCost() {
        return cost;
    }
    
}
