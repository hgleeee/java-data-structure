package ch06_avl_trees;

public interface Tree<E> {

    public void insert(E data);
    public void delete(E data);
    public void traverse();
}
