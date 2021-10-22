package main.java;

public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();

        heap.insert(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);

        System.out.println(heap.toString());

        Iterator bft = heap.createBFTIterator();
        Iterator dft = heap.createDFTIterator();

        while (dft.hasNext()) {
            System.out.print(dft.next() + " ");
        }
    }
}
