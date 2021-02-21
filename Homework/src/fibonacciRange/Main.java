package fibonacciRange;

public class Main {

    public static void main(String[] args) {
        FibonacciRange range = new FibonacciRange(10);
        while (range.iterator().hasNext()) {
            System.out.println(range.iterator().next());
        }
    }
}
