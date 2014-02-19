package Structures;

/**
 *
 * Minimum heap used with A*
 *
 * @author tomminikkanen
 */
public class MinHeap {

    private StarNode[] heap;
    private int size;

    /**
     *
     * @param size
     */
    public MinHeap(int size) {
        this.heap = new StarNode[size + 1];
        this.size = 0;
    }

    /**
     * Returns the left child for the given position
     *
     * @param position
     * @return int position
     */
    private int left(int position) {
        return 2 * position;
    }

    /**
     * Returns the right child for the given position
     *
     * @param position
     * @return int position
     */
    private int right(int position) {
        return 2 * position + 1;
    }

    /**
     * Checks if the given node is a leaf
     *
     * @param position
     * @return is leaf?
     */
    private boolean leaf(int position) {
        return ((position > size / 2) && position <= size);
    }

    private int parent(int position) {
        return position / 2;
    }

    /**
     *
     * Method for inserting a node into the heap
     *
     * @param node
     */
    public void insert(StarNode node) {
        if (size < heap.length) {
            int i = size;
            heap[i] = node;

            while (i > 1 && heap[parent(i)].getTotalCost() > node.getTotalCost()) {
                swap(i, parent(i));
                i = parent(i);
            }

            size++;
        }
    }

    /**
     * Swaps the given nodes
     *
     * @param p1
     * @param p2
     */
    private void swap(int p1, int p2) {
        StarNode temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    /**
     * Used to balance the heap
     *
     * @param i
     */
    private void heapify(int i) {
        int smaller;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left >= size && right >= size) {
            return;
        } else {
            if (heap[left].getTotalCost() < heap[right].getTotalCost()) {
                smaller = left;
            } else {
                smaller = right;
            }

            if (smaller != i) {
                swap(i, smaller);
                heapify(smaller);
            }
        }
    }

    /**
     * Removes and returns the smallest node in the heap
     *
     * @return
     */
    public StarNode removeSmallest() {
        if (size >= 1) {
            StarNode smallest = heap[0];
            heap[0] = heap[size - 1];
            size--;
            if (size > 0) {
                heapify(0);
            }
            return smallest;
        } else {
            return null;
        }
    }

    /**
     * Checks if the heap is empty
     *
     * @return
     */
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }

    /**
     * Returns the current heap as a array
     *
     * @return
     */
    public StarNode[] currentNodes() {
        return heap;
    }

    @Override
    public String toString() {
        String returnable = "[Size:"+size+"]";
        if (heap.length > 0) {
            for (StarNode sn : heap) {
                if(sn != null) {
                    returnable += sn;
                }
            }
        }
        return returnable;
    }
}
