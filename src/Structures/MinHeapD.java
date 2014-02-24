
package Structures;

/**
 *
 * @author tomminikkanen
 */
public class MinHeapD {
    private DNode[] heap;
    private int size;
    
    /**
     * Constructor
     * @param size
     */
    public MinHeapD(int size) {
        heap = new DNode[size+1];
        size = 0;
    }
    
    /**
     * returns the index of the parent node
     * @param i
     * @return 
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }
    
    /**
     * swaps two nodes in the heap
     * @param n1
     * @param n2 
     */
    private void swap(int n1, int n2) {
        DNode temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }
    
    /**
     * Removes and returns the smallest node
     * @return
     */
    public DNode removeSmallest() {
        if (size < 1) {
            return null;
        }
        
        DNode smallest = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) {
            heapify(0);
        }
        return smallest;
    }
    
    /**
     * Used to balance the heap
     * @param i 
     */
    private void heapify(int i) {
        int smaller;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left >= size && right >= size) {
            return;
        }

        if (heap[left].getCostToThisPoint() < heap[right].getCostToThisPoint()) {
            smaller = left;
        } else {
            smaller = right;
        }

        if (smaller != i) {
            swap(i, smaller);
            heapify(smaller);
        }
    }
    
    /**
     * @deprecated 
     * @param i
     * @param val
     */
    public void decKey(int i, int val) {
        if (heap[i].getCostToThisPoint() > val) {
            heap[i].setCostToThisPoint(val);
            heapify(i);
        }
    }
    
    /**
     * Inserts the given node into the right place
     * @param node
     */
    public void insert(DNode node) {
                if (size == heap.length) {
            return;
        }

        int i = size;
        heap[i] = node;

        while (i > 1 && heap[parent(i)].getCostToThisPoint() > node.getCostToThisPoint()) {
            swap(i, parent(i));
            i = parent(i);
        }

        size++;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
