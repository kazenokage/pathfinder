package Structures;

public class BMFNode implements Node {
    
    private int costToThisPoint;
    private int type;
    private BMFNode previous;
    
    public BMFNode(int type) {
        this.type = type;
    }
    
    public void setCostToThisPoint(int cost) {
        this.costToThisPoint = cost;
    }
    
    public int getCostToThisPoint() {
        return this.costToThisPoint;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public void setPreviousNode(BMFNode prev) {
        this.previous = prev;
    }
    
    public BMFNode getPrevious() {
        return this.previous;
    }
    
}
