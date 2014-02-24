
package Structures;

/**
 *
 * Node for A* algo
 * 
 * @author tomminikkanen
 */
public class StarNode implements Comparable<StarNode>, Node {
    /**
     * The type and coordinates of the node
     */
    private int type;
    private int x;
    private int y;
   
    private double totalCost;
    private double costToThisPoint;
    private double guessedCostToGoal;
    
    private StarNode previous;
    
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
        this.totalCost = 0;
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
    
    public void setType(int type) {
        this.type = type;
    }
    
    public void setPrevious(StarNode previous) {
        this.previous = previous;
    }
    
    public StarNode getPrevious() {
        return previous;
    }
    
    /**
     * 
     * @return 
     */
    public double getCostToThisPoint() {
        return this.costToThisPoint;
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
    public void setTotalCost() {
        totalCost = costToThisPoint + guessedCostToGoal;
    }
    
    /**
     *
     * @return total cost
     */
    public double getTotalCost() {
        return totalCost;
    }
    
    /**
     * Overrided compareTo -function to decide the best cost between nodes
     * 
     * @param node to compare to
     */
    
    @Override
    public int compareTo(StarNode o) {
        if (this.totalCost > o.totalCost) {
            return 1;
        } else if (this.totalCost == o.totalCost) {
            return 0;
        } else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "["+x+","+y+"|"+type+"]<"+totalCost+"/"+costToThisPoint+"/"+guessedCostToGoal+">";
    }
    
    
    
}
