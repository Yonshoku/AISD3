package main.java;

import java.util.ArrayList;

public class DFTIterator extends Iterator{
    Arr heap;
    Arr path = new Arr(); // False = left, True = right
    int passed = 0;
    int cur_index = 0;

    public DFTIterator(Arr heap) {
        this.heap = heap;
    }

    @Override
    public int next() {
        if (path.size() == 0) {
            path.add(0);
            cur_index = 0;

        } else if (path.get(path.size() - 1) == 0 && (cur_index * 2 + 1) < heap.size()) { // Go to the left son
            cur_index = cur_index * 2 + 1;
            path.add(0);

        } else if (path.get(path.size() - 1) == 1 && (cur_index * 2 + 2) < heap.size()) { // Go to the right son
            cur_index = cur_index * 2 + 2;
            path.add(0);

        } else { // No son left, go up until parent with son
            path.pop_back();
            cur_index = (cur_index - 1) / 2;

            while (path.get(path.size() - 1) == 1) {
                cur_index = (cur_index - 1) / 2;
                path.pop_back();
            }

            path.set(path.size() - 1, 1);
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
