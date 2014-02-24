
package Structures;


/**
 *
 * @author tomminikkanen
 */
public class DNode implements Node, Comparable<DNode> {
    
    /**
     * x-coordinate
     */
    private int x;
    /**
     * y-coordinate
     */
    private int y;
    /**
     * type of node
     */
    private int type;
    /**
     * cost to this point
     */
    private int costToThisPoint;
    /**
     * previous DNode
     */
    private DNode previous;
    
    /**
     * Constructor
     * @param x
     * @param y
     * @param type
     */
    public DNode(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    /**
     *
     * @param cost
     */
    public void setCostToThisPoint(int cost) {
        costToThisPoint = cost;
    }
    
    /**
     *
     * @return
     */
    public int getCostToThisPoint() {
        return costToThisPoint;
    }
    
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }
    
    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }
    
    /**
     *
     * @param prev
     */
    public void setPrevious(DNode prev) {
        previous = prev;
    }
    
    /**
     *
     * @return
     */
    public DNode getPrevious() {
        return previous;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    @Override
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Compares this node to other node
     * @param o
     * @return 
     */
    @Override
    public int compareTo(DNode o) {
        if (this.costToThisPoint > o.costToThisPoint) {
            return 1;
        } else if(this.costToThisPoint == o.costToThisPoint) {
            return 0;
        } else {
            return -1;
        }
    }

}
