package ch08_hashtable.chaining;

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
        // 키를 해싱
        int hashIndex = hash(key);

        // 해시 테이블의 슬롯이 비어 있으면 바로 삽입
        if (hashTable[hashIndex] == null) {
            hashTable[hashIndex] = new Item(key, value);
            return;
        }
        // 해쉬 테이블의 슬롯이 비어있지 않으면
        Item item = hashTable[hashIndex]; // 해시테이블 슬롯에 저장된 첫번째 항목 추출

        while (item.getNextItem() != null) {
            item = item.getNextItem();
        }
        // 마지막으로 연결 리스트 다음에 삽입
        item.setNextItem(new Item(key, value));
    }

    // 반환
    public int get(int key) {

        // 입력받은 키값을 해싱
        int generatedArrayIndex = hash(key);

        // 해시 값에 해당하는 슬롯에 데이터가 없으면 -1 리턴
        if (hashTable[generatedArrayIndex] == null) {
            return -1;
        }

        // 해시 값에 해당하는 슬롯에 데이터가 있는 경우
        // 첫번째 항목 추출
        Item item = hashTable[generatedArrayIndex];

        // 입력 키 값과 항목의 키 값이 일치할 때까지 탐색
        while (item != null && item.getKey() != key) {
            item = item.getNextItem();
        }

        // 마지막까지 탐색한 뒤 일치하는 값을 못찾은 경우 -1 리턴
        if (item == null) {
            return -1;
        }
        return item.getValue();
    }
}
