package Structures;

public class MinHeap {

    private int[] heap;
    private int size;
    private int max;

    public MinHeap(int max) {
        this.max = max;
        this.heap = new int[max];
        size = 0;
        heap[0] = 0;
    }

    private int left(int position) {
        return 2 * position;
    }

    private int right(int position) {
        return 2 * position + 1;
    }
    
    private boolean leaf(int position) {
        return ((position > size/2) && position <= size);
    }
    
    private int parent(int position) {
        return position/2;
    }
}
