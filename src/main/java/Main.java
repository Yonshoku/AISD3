package main.java;

public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();

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

        System.out.println("Heap: " + heap.toString());

        heap.remove(10);
        heap.remove(3);

        System.out.println("Heap after remove(10), remove(3): " + heap.toString());

        Iterator bft = heap.createBFTIterator();
        Iterator dft = heap.createDFTIterator();

        System.out.println("Order of elements after breadth-first traverse:");
        while (bft.hasNext()) {
            System.out.print(bft.next() + " ");
        }
        System.out.println();

        System.out.println("Order of elements after depth-first traverse:");
        while (dft.hasNext()) {
            System.out.print(dft.next() + " ");
        }
    }
}
