package ch07_heap;

public class HeapTest {

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(50);
        heap.offer("apple");
        heap.offer("banana");
        System.out.println(heap.getMaxPriority()); // banana
        heap.offer("candy");
        System.out.println(heap.getMaxPriority()); // candy
        heap.offer("dragon");
        System.out.println(heap.getMaxPriority()); // dragon
        heap.offer("earth");
        System.out.println(heap.getMaxPriority()); // earth
        heap.offer("fruit");
        System.out.println(heap.getMaxPriority()); // fruit
        heap.poll();
        System.out.println(heap.getMaxPriority()); // earth
        heap.poll();
        System.out.println(heap.getMaxPriority()); // dragon
        heap.poll();
        System.out.println(heap.getMaxPriority()); // candy
        heap.poll();
        System.out.println(heap.getMaxPriority()); // banana
    }
}
