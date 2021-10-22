package main.java;

import java.util.ArrayList;

public class DFTIterator extends Iterator{
    ArrayList<Integer> heap;
    ArrayList<Boolean> path = new ArrayList<Boolean>(); // False = left, True = right
    int passed = 0;
    int cur_index = 0;

    public DFTIterator(ArrayList<Integer> heap) {
        this.heap = heap;
    }

    @Override
    public int next() {
        if (path.size() == 0) {
            path.add(false);
            cur_index = 0;

        } else if (!path.get(path.size() - 1) && (cur_index * 2 + 1) < heap.size()) { // Go to the left son
            cur_index = cur_index * 2 + 1;
            path.add(false);

        } else if (path.get(path.size() - 1) && (cur_index * 2 + 2) < heap.size()) { // Go to the right son
            cur_index = cur_index * 2 + 2;
            path.add(false);

        } else { // No son left, go up until parent with son
            path.remove(path.size() - 1);
            cur_index = (cur_index - 1) / 2;

            while (path.get(path.size() - 1)) {
                cur_index = (cur_index - 1) / 2;
                path.remove(path.size() - 1);
            }

            path.set(path.size() - 1, true);
            passed--;
            next();
        }

        passed++;
        return heap.get(cur_index);
    }

    @Override
    public boolean hasNext() {
        return passed < heap.size();
    }
}
