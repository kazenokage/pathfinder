package Structures;

public class MinHeap {

    private StarNode[] heap;
    private int size;

    public MinHeap(int size) {
        this.heap = new StarNode[size + 1];
        this.size = 0;
    }

    private int left(int position) {
        return 2 * position;
    }

    private int right(int position) {
        return 2 * position + 1;
    }

    private boolean leaf(int position) {
        return ((position > size / 2) && position <= size);
    }

    private int parent(int position) {
        return position / 2;
    }

    public void insert(StarNode node) {
        if (size < heap.length) {
            int i = size;
            heap[i] = node;

            while (i > 1 && heap[parent(i)].getCost() > node.getCost()) {
                swap(i, parent(i));
                i = parent(i);
            }

            size++;
        }
    }

    private void swap(int p1, int p2) {
        StarNode temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    private void heapify(int i) {
        int smaller;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left >= size && right >= size) {
            return;
        } else {
            if (heap[left].getCost() < heap[right].getCost()) {
                smaller = left;
            } else {
                smaller = right;
            }
            
            if (smaller != i) {
                swap(i,smaller);
                heapify(smaller);
            }
        }
    }
    
    public StarNode removeSmallest() {
        if (size>=1) {
            StarNode smallest = heap[0];
            heap[0] = heap[size-1];
            size--;
            if (size > 0) {
                heapify(0);
            }
            return smallest;
        } else {
            return null;
        }
    }
    
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }
}
