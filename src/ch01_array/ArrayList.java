package ch01_array;

import java.util.NoSuchElementException;

public class ArrayList<E> {

    private E[] arr;
    private int size;

    public ArrayList() {
        arr = (E[]) new Object[1];
        size = 0;
    }

    // 탐색 연산
    public E get(int index) {
        if (size <= index) {
            throw new NoSuchElementException();
        }
        return arr[index];
    }

    // 삽입 연산
    public void add(E item) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = item;
    }

    // 특정 인덱스 삽입 연산
    public void add(E item, int index) {
        if (size == arr.length) {
            resize(2 * arr.length);

            // 특정 인덱스로부터 한 칸씩 뒤로 이동
            for (int i = size-1; i >= index; --i) {
                arr[i+1] = arr[i];
            }

            arr[index] = item;
            size++;
        }
    }

    public E remove(int index) {
        if (size <= index) {
            throw new NoSuchElementException();
        }
        E item = arr[index];
        // 특정 index로부터 데이터 한 칸씩 앞으로 이동
        for (int i = index; i < size; ++i) {
            arr[i] = arr[i+1];
        }
        size--;
        // 배열에 저장된 항목이 1/4만 차지한다면 배열의 크기를 반으로 축소
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void resize(int nSize) {
        Object[] nArr = new Object[nSize];
        for (int i = 0; i < size; ++i) {
            nArr[i] = arr[i];
        }
        arr = (E[]) nArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size-1; ++i) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[size-1]).append(" ]");
        return sb.toString();
    }

}
