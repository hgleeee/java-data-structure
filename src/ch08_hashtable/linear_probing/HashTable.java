package ch08_hashtable.linear_probing;

public class HashTable {

    private Item[] hashTable;

    public HashTable() {
        this.hashTable = new Item[Constants.TABLE_SIZE];
    }

    // 해시 함수
    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }

    // 삽입
    public void put(int key, int value) {

        int generatedIndex = hash(key); // 키 해싱
        System.out.println("put() method called with value : " + value + ", generatedIndex : " + generatedIndex);

        // 충돌이 없을 때까지 반복 수행
        while (hashTable[generatedIndex] != null) {
            // 인덱스 1씩 증가
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Collision -> move to next index : " + generatedIndex);
        }

        // 빈 슬롯에 항목 삽입
        System.out.println("Inserted finally with index : " + generatedIndex);
        hashTable[generatedIndex] = new Item(key, value);
    }

    // 반환
    public int get(int key) {

        int generatedIndex = hash(key); // 키 해싱

        // 입력받은 키값이 동일할 때까지 반복 수행
        while (hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey() != key) {
            // 인덱스 1씩 증가
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Not Matched : move to next index  : " + generatedIndex);
        }

        // 키에 대응하는 값을 찾지 못한 경우 -1을 리턴
        if (hashTable[generatedIndex] == null) {
            return -1;
        }
        return hashTable[generatedIndex].getValue();
    }
}
