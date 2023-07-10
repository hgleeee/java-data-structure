package ch02_linked_list;

public class LinkedList<E extends Comparable<E>> implements List<E> {

    private Node<E> root;
    private int size;

    @Override
    public void insert(E data) {
        ++this.size;
        if (root == null) {
            this.root = new Node<>(data);
            return;
        }
        insertFirst(data);
    }

    private void insertFirst(E data) {
        Node<E> node = new Node<>(data);
        node.setNextNode(root);
        this.root = node;
    }

    private void insertEnd(E data, Node<E> node) {
        // 노드의 다음 노드가 null이 아니면, 즉 마지막 노드가 아니면
        if (node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
            return;
        }

        Node<E> newNode = new Node<>(data);
        node.setNextNode(newNode);

    }

    @Override
    public void remove(E data) {
        if (this.root == null) {
            return;
        }
        --this.size;
        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
            return;
        }
        remove(data, root, root.getNextNode());
    }

    private void remove(E dataToRemove, Node<E> prevNode, Node<E> nowNode) {
        while (nowNode != null) {
            // 삭제할 데이터와 현재 노드의 데이터가 같으면 삭제 처리
            if (nowNode.getData().compareTo(dataToRemove) == 0) {
                // 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 설정
                prevNode.setNextNode(nowNode.getNextNode());
                return;
            }
            prevNode = nowNode;
            nowNode = nowNode.getNextNode();
        }
    }

    @Override
    public void print() {
        if (this.root == null) {
            return;
        }
        Node<E> actualNode = this.root;
        // 리스트 전체 탐색
        while (actualNode != null) {
            System.out.print(actualNode + " --> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return this.size;
    }
}
