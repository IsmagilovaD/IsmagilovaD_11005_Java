package rangeInterval;

public class Range implements Iterable<Integer> {

    private final int length;
    protected int counter;

    public Range(int length) {
        this.length = length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public Integer next() {
                return counter++;
            }

            @Override
            public boolean hasNext() {
                return counter < length;
            }

        };
    }
}
