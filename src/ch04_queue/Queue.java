package ch04_queue;

public class Queue<E extends Comparable<E>> {

    private Node<E> firstNode, lastNode;
    private int size;

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public int size() {
        return this.size;
    }

    public void offer(E data) {
        this.size++;
        Node<E> originLastNode = this.lastNode;
        this.lastNode = new Node<>(data);
        this.lastNode.setNextNode(null);
        if (isEmpty()) {
            this.firstNode = this.lastNode;
            return;
        }
        originLastNode.setNextNode(this.lastNode);
    }

    public E peek() {
        return this.firstNode.getData();
    }

    public E poll() {
        this.size--;
        E dataToPoll = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }
        return dataToPoll;
    }
}
