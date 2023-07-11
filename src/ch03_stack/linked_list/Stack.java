package ch03_stack.linked_list;

public class Stack<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public void push(E data) {
        this.size++;
        if (this.root == null) {
            this.root = new Node<>(data);
            return;
        }
        Node<E> originRoot = this.root;
        this.root = new Node<>(data);
        this.root.setNextNode(originRoot);
    }

    public E pop() {
        E itemToPop = this.root.getData();
        this.root = this.root.getNextNode();
        this.size--;
        return itemToPop;
    }

    public E peek() {
        return this.root.getData();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
