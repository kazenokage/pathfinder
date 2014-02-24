
package Structures;


public class DNode implements Node, Comparable<DNode> {

    private int x;
    private int y;
    private int type;
    
    private int costToThisPoint;
    
    private DNode previous;
    
    public DNode(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    public void setCostToThisPoint(int cost) {
        costToThisPoint = cost;
    }
    
    public int getCostToThisPoint() {
        return costToThisPoint;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPrevious(DNode prev) {
        previous = prev;
    }
    
    public DNode getPrevious() {
        return previous;
    }
    
    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

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
