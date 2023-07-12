package ch07_heap;

public class Heap<E extends Comparable<E>> {

    private E[] heap;       // heap
    private int size;       // heap 크기

    public Heap(int capacity) {
        this.heap = (E[]) new Comparable[capacity];
    }

    public void offer(E item) {

        if (isHeapFull()) {
            throw new RuntimeException("Heap is full..");
        }

        this.heap[this.size] = item;
        this.size++;
        fixUp(size-1);
    }

    private boolean isHeapFull() {
        return this.heap.length == this.size;
    }

    private void fixUp(int curIdx) {
        int parentIdx = (curIdx - 1) / 2;
        if (curIdx > 0 && heap[curIdx].compareTo(heap[parentIdx]) > 0) {
            swap(curIdx, parentIdx);
            fixUp(parentIdx);
        }
    }

    private void swap(int idx1, int idx2) {
        E tmp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = tmp;
    }

    public E poll() {
        if (size == 0) throw new RuntimeException("Heap is empty..");
        E max = getMaxPriority();
        heap[0] = heap[size-1];
        size--;
        fixDown(0);
        return max;
    }

    private void fixDown(int curIdx) {
        int leftChildIdx = curIdx*2+1, rightChildIdx = curIdx*2+2;
        int largestIdx = curIdx;

        // 상위노드보다 왼쪽 하위 노드가 더 우선일 경우
        if (leftChildIdx < size && heap[leftChildIdx].compareTo(heap[largestIdx]) > 0) {
            largestIdx = leftChildIdx;
        }

        // 왼쪽 하위 노드보다 오른쪽 하위 노드가 더 우선일 경우
        if (rightChildIdx < size && heap[rightChildIdx].compareTo(heap[largestIdx]) > 0) {
            largestIdx = rightChildIdx;
        }

        if (curIdx != largestIdx) {
            swap(curIdx, largestIdx);
            fixDown(largestIdx);
        }
    }

    public E getMaxPriority() {
        return this.heap[0];
    }

    public void printHeap() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
