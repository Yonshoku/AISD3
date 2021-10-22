package test.java;

import main.java.*;
import org.junit.*;

import static org.junit.Assert.*;

public class BinaryHeapTest {
    BinaryHeap heap;
    int[] heap_after_insert = {10, 9, 10, 7, 4, 2, 8, 5, 6, 1, 3, 0};
    int[] heap_after_remove = {10, 9, 2, 7, 3, 1, 0, 5, 6};
    int[] bft_iterator_order = {10, 9, 10, 7, 4, 2, 8, 5, 6, 1, 3, 0};
    int[] dft_iterator_order = {10, 9, 7, 5, 6, 4, 1, 3, 10, 2, 0, 8};

    @Before
    public void setUp() {
        heap = new BinaryHeap(); // Clear heap
        heap.insert(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(5);
        heap.insert(1);
        heap.insert(0);
        heap.insert(10);
        heap.insert(7);
        heap.insert(6);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
    }

    @Test
    public void testInsert() {
        // heap filled in setUp()

        for (int i = 0; i < heap_after_insert.length; i++) {
            assertEquals(heap.get(i), heap_after_insert[i]);
        }
    }

    @Test
    public void testRemove() {
        heap.remove(8);
        heap.remove(4);
        heap.remove(10);

        for (int i = 0; i < heap_after_remove.length; i++) {
            assertEquals(heap.get(i), heap_after_remove[i]);
        }
    }

    @Test
    public void testContains() {
        assertTrue(heap.contains(7));
        assertTrue(heap.contains(10));
        assertFalse(heap.contains(11));
    }

    @Test
    public void testBFTIterator() {
        Iterator it = heap.createBFTIterator();

        int i = 0;
        while(it.hasNext()) {
            assertEquals(bft_iterator_order[i], it.next());
            i++;
        }
    }

    @Test
    public void testDFTIterator() {
        Iterator it = heap.createDFTIterator();

        int i = 0;
        while(it.hasNext()) {
            assertEquals(dft_iterator_order[i], it.next());
            i++;
        }
    }
}
