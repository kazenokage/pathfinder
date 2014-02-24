
package Structures;

public class MinHeapD {
    private DNode[] heap;
    private int size;
    
    public MinHeapD(int size) {
        heap = new DNode[size+1];
        size = 0;
    }
    
    private int parent(int i) {
        return (i - 1) / 2;
    }
    
    private void swap(int n1, int n2) {
        DNode temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }
    
    public DNode removeSmallest() {
        if (size < 1) {
            return null;
        }
        
        DNode pienin = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) {
            heapify(0);
        }
        return pienin;
    }
    
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
    
    public void decKey(int i, int val) {
        if (heap[i].getCostToThisPoint() > val) {
            heap[i].setCostToThisPoint(val);
            heapify(i);
        }
    }
    
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
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
