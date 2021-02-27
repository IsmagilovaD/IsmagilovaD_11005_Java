package stackIterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        for (Integer item : stack) {
            System.out.println(item);
        }
    }
}
