package main.java;

import java.util.Arrays;

public class Arr {
    int length = 0;
    int capacity = 10;
    private int[] arr = new int[capacity];

    void extend() {
        capacity += 10;
        arr = Arrays.copyOf(arr, capacity);
    }

    void add(int elem) {
        if (length == capacity) extend();

        arr[length] = elem;
        length++;
    }

    void set(int index, int elem) {
        arr[index] = elem;
    }

    int get(int index) {
        return arr[index];
    }

    int size() {
        return length;
    }

    boolean contains(int key) {
        for (int elem : arr) {
            if (elem == key) return true;
        }

        return false;
    }

    void pop_back() {
        length--;
    }

    int indexOf(int key) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == key) return i;
        }

        return -1;
    }

}
