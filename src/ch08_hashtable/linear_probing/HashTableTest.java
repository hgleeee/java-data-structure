package ch08_hashtable.linear_probing;

public class HashTableTest {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put(1, 10);
        System.out.println();
        hashTable.put(2, 20);
        System.out.println();
        hashTable.put(3, 30);
        System.out.println();
        hashTable.put(11, 50);
        System.out.println();

        System.out.println(hashTable.get(11));
    }
}
