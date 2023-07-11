package ch05_binary_search_tree;

public interface Tree<E> {

    public void insert(E data);
    public E getMinValue();
    public E getMaxValue();
    public void traversal();
    public void delete(E data);
}
