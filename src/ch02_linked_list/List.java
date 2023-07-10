package ch02_linked_list;

public interface List<E> {

    public void insert(E data);
    public void remove(E data);
    public void print();
    public int size();
}
