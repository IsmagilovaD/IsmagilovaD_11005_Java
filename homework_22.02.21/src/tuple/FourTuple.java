package tuple;

public class FourTuple<A,B,C,D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A first, B second, C thirst, D fourth) {
        super(first, second, thirst);
        this.fourth = fourth;
    }
}
