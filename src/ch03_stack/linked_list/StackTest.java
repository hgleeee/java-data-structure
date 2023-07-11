package ch03_stack.linked_list;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println(stack.isEmpty()); // true

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.isEmpty()); // false;

        System.out.println(stack.peek());    // D
        System.out.println(stack.pop());     // D
        System.out.println(stack.pop());     // C
        System.out.println(stack.pop());     // B
        System.out.println(stack.peek());    // A
        System.out.println(stack.size());    // 1
    }
}
