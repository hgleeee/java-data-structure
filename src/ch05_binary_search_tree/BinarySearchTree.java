package ch05_binary_search_tree;

public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {

    private Node<E> root;

    @Override
    public void insert(E data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }
        insertNode(data, root);
    }

    @Override
    public E getMinValue() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    @Override
    public E getMaxValue() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    @Override
    public void traversal() {
        if (root != null) {
            inOrderTraversal(root);
            System.out.println();
            preOrderTraversal(root);
            System.out.println();
            postOrderTraversal(root);
            System.out.println();
        }
    }

    @Override
    public void delete(E data) {
        if (root != null) {
            root = delete(root, data);
        }
    }

    private void insertNode(E data, Node<E> node) {
        // 새로 추가할 데이터가 현 노드의 데이터보다 작을 경우
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(data, node.getLeftChild());
                return;
            }
            node.setLeftChild(new Node<>(data));
            return;
        }
        // 새로 추가할 데이터가 현 노드의 데이터보다 크거나 같을 경우
        if (data.compareTo(node.getData()) >= 0) {
            if (node.getRightChild() != null) {
                insertNode(data, node.getRightChild());
                return;
            }
            node.setRightChild(new Node<>(data));
        }
    }

    private E getMin(Node<E> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    private E getMax(Node<E> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    private void inOrderTraversal(Node<E> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + " --> ");
        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    private void preOrderTraversal(Node<E> node) {
        System.out.print(node + " --> ");
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(Node<E> node) {
        if (node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }
        System.out.print(node + " --> ");
    }

    private Node<E> delete(Node<E> node, E data) {
        if (node == null) {
            return null;
        }
        // 삭제할 데이터가 현재 노드의 데이터보다 작다면 왼쪽 하위노드 탐색
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));
            return node;
        }
        // 삭제할 데이터가 현재 노드의 데이터보다 크다면 오른쪽 하위노드 탐색
        if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));
            return node;
        }
        if (data.compareTo(node.getData()) == 0) {
            if (node.getLeftChild() == null && node.getRightChild()== null) {
                System.out.println("removing a leaf node...");
                return null;
            }
            // 왼쪽 하위노드가 null 이면 : 오른쪽 하위 노드만 있다면
            if (node.getLeftChild() == null) {
                System.out.println("removing the right child...");
                Node<E> tempNode = node.getRightChild();
                return tempNode;
            }
            // 오른쪽 하위노드가 null 이면 : 왼쪽 하위 노드만 있다면
            if (node.getRightChild() == null) {
                System.out.println("removing the left child...");
                Node<E> tempNode = node.getLeftChild();
                return tempNode;
            }
            // 하위노드가 2개인 경우
            System.out.println("removing item with two children...");
            // 왼쪽의 하위 노드중에서 가장 큰 노드 탐색
            Node<E> tempNode = getPredecessor(node.getLeftChild());
            // 삭제하려는 노드와 왼쪽 하위노드에서 가장 큰 노드와 swap
            node.setData(tempNode.getData());
            // 삭제 재귀 호출
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
        }
        return node;
    }

    // 가장 큰 노드 탐색
    private Node<E> getPredecessor(Node<E> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        System.out.println("Predecessor : " + node);
        return node;
    }
}
