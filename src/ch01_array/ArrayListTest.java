package ch01_array;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        System.out.println(arrayList);
        arrayList.add("banana");
        System.out.println(arrayList);
        arrayList.add("carrot");
        System.out.println(arrayList);
        arrayList.add("eggplant");
        System.out.println(arrayList);
        arrayList.add("dragon fruit", 3);
        System.out.println(arrayList);

        arrayList.remove(3); // dragon fruit 삭제
        System.out.println(arrayList);
        arrayList.remove(1); // banana 삭제
        System.out.println(arrayList);
    }
}
