package rangeInterval;

public class RangeInterval extends Range {

    private final int end;
    private int start;

    public RangeInterval(int start, int end){
        super(end);
        this.start = start;
        this.end = end;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public Integer next() {
                return start++;
            }

            @Override
            public boolean hasNext() {
                return start < end;
            }

        };
    }
}
