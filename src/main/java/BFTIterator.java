package main.java;

import java.util.ArrayList;

public class BFTIterator extends Iterator{
    ArrayList<Integer> heap;
    int cur_index;
    
    public BFTIterator(ArrayList<Integer> heap) {
        this.heap = heap;
    }
    
    @Override
    public int next() {
        cur_index++;
        return heap.get(cur_index - 1);
    }

    @Override
    public boolean hasNext() {
        return cur_index < heap.size();
    }
}
