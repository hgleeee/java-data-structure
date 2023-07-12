package ch06_avl_trees;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree<String> avlTree = new AVLTree<>();
        avlTree.insert("apple");
        avlTree.insert("banana");
        avlTree.insert("candy");
        avlTree.insert("dragon");
        avlTree.insert("earth");
        avlTree.traverse();
        avlTree.delete("candy");
        avlTree.traverse();
    }
}
