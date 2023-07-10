package ch03_stack.array;

public class Stack<E> {

    private E[] arr;
    private int size;

    public Stack() {
        this.arr = (E[]) new Object[1];
    }

    public void push(E data) {
        if (size == this.arr.length) {
            resize(2 * this.arr.length);
        }
        this.arr[size++] = data;
    }

    public E pop() {
        E itemToPop = this.arr[--size];
        if (size > 0 && size == this.arr.length / 4) {
            resize(this.arr.length / 2);
        }
        return itemToPop;
    }

    public E peek() {
        return this.arr[size-1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        E[] mockArr = (E[]) new Object[capacity];
        for (int i = 0; i < size; ++i) {
            mockArr[i] = this.arr[i];
        }
        this.arr = mockArr;
    }
}
