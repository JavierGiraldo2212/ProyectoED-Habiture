import DataStructures.*;

public class Habiture {

	public static void main(String[] args) {
        // Create a NodeStack instance
        NodeStack<Integer> stack = new NodeStack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(100);

        // Pop elements from the stack
        System.out.println(stack.pop());  // Output: 100
        System.out.println(stack.pop());  // Output: 30

        // Peek at the top element of the stack
        System.out.println(stack.peek()); // Output: 20
        System.out.println(stack.pop()); // Output: 20
    }

}
