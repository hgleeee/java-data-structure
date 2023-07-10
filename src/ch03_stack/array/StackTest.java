package ch03_stack.array;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println("stack size : " + myStack.size()); // 4
        System.out.println("stack peek : " + myStack.peek()); // D
        System.out.println("stack pop : " + myStack.pop());   // D
        System.out.println("stack pop : " + myStack.pop());   // C
        System.out.println("stack pop : " + myStack.pop());   // B
        System.out.println("stack peek : " + myStack.peek()); // A
    }
}
