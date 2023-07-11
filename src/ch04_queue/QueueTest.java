package ch04_queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("candy");
        queue.offer("dragon");

        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            System.out.println(queue.poll());
        }
        // queue에 넣은 순서대로 출력

    }
}
