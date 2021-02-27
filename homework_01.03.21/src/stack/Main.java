package stack;

public class Main {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        int y = stack.pop();
        int x = stack.peek();
        System.out.println(x);
        System.out.println(y);
    }
}
