package main.java;

public class BinaryHeap {
     Arr heap = new Arr();

    void swap(Arr heap, int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    void siftUp(int index) {
        while (index != 0 && heap.get(index) > heap.get((index - 1) / 2)) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    void siftDown(int index) {;
        int left_index, right_index, swap_index;

        while (index * 2 + 1 < heap.size()) {
            left_index = index * 2 + 1;
            right_index = index * 2 + 2;

            if (right_index < heap.size() && heap.get(right_index) > heap.get(left_index)) swap_index = right_index;
            else swap_index = left_index;

            if (heap.get(index) > heap.get(swap_index)) break; // Heap correct already
            swap(heap, index, swap_index);
            index = swap_index;
        }
    }

    public void insert(int key) {
        heap.add(key);
        siftUp(heap.size() - 1);
    }

    public boolean contains(int key) {
        return heap.contains(key);
    }

    public void remove(int key) {
        int index = heap.indexOf(key);
        swap(heap, index, heap.size() - 1);
        heap.pop_back();
        siftDown(index);
    }

    public Iterator createBFTIterator() {
        return new BFTIterator(heap);
    }

    public Iterator createDFTIterator() {
        return new DFTIterator(heap);
    }

    public int get(int index) {
        return heap.get(index);
    }

    @Override
    public String toString() {
        String heapString = "[";

        for (int i = 0; i < heap.size() - 1; i++) {
            heapString += heap.get(i) + ", ";
        }
        heapString += heap.get(heap.size() - 1) + "]";

        return heapString;
    }
}

class Node {
    int value;
    Node next;
    Node prev;
}