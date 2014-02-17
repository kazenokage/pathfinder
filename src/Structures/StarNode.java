
package Structures;

/**
 *
 * Node for A* algo
 * 
 * @author tomminikkanen
 */
public class StarNode implements Comparable<StarNode> {
    private int type;
    private int x;
    private int y;
    
    private double cost;
    private double costToThisPoint;
    private double guessedCostToGoal;
    
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
     * @return type of node
     */
    public int getType() {
        return type;
    }
    
    /**
     *
     * @param c the cost to be set
     */
    public void setCostToThisPoint(double c) {
        this.costToThisPoint = c;
    }
    
    /**
     *
     * @param g guess to be set
     */
    public void setGuessedCostToGoal(double g) {
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
    public double getCost() {
        return cost;
    }
    
    /**
     * Overrided compareTo -function to decide the best cost between nodes
     * 
     * @param node to compare to
     */
    
    @Override
    public int compareTo(StarNode o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost == o.cost) {
            return 0;
        } else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return x+","+y;
    }
    
    
    
}
