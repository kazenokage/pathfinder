package Structures;

/**
 * Node for BMF
 * 
 * @author tomminikkanen
 */
public class BMFNode implements Node {
    
    /**
     * Cost to current position
     */
    private int costToThisPoint;
    /**
     * Type of the node
     */
    private int type;
    /**
     * Previous BMFNode
     */
    private BMFNode previous;
    
    /**
     * Constructor
     * @param type
     */
    public BMFNode(int type) {
        this.type = type;
    }
    
    /**
     * Sets the cost to current point
     * @param cost 
     */
    public void setCostToThisPoint(int cost) {
        this.costToThisPoint = cost;
    }
    
    /**
     * Returns the cost to current point
     * @return
     */
    public int getCostToThisPoint() {
        return this.costToThisPoint;
    }
    
    /**
     * Returns the type of the node
     * @return
     */
    public int getType() {
        return this.type;
    }
    
    /**
     * Sets the type
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * Returns the previous node
     * @param prev
     */
    public void setPreviousNode(BMFNode prev) {
        this.previous = prev;
    }
    
    /**
     * Returns the previous node
     * @return
     */
    public BMFNode getPrevious() {
        return this.previous;
    }
    
}
