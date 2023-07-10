package ch02_linked_list;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");

        System.out.println(myLinkedList.size());
        myLinkedList.print();

        myLinkedList.remove("D");
        myLinkedList.print();

        myLinkedList.remove("A");
        myLinkedList.print();
    }
}
