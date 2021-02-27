package fibonacciRange;

public class FibonacciRange implements Iterable<Integer> {
    private final int length;
    protected int counter;
    private int x = 0;
    private int y = 1;
    private int num;

    public FibonacciRange(int length){
        this.length = length;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public Integer next() {
                if (counter == 0) {
                    counter++;
                    return 0;
                }

                if (counter == 1) {
                    counter++;
                    return 1;
                }

                num = x + y;
                x = y;
                y = num;
                counter++;

                return num;
            }

            @Override
            public boolean hasNext() {
                return counter < length;
            }
        };
    }
}
