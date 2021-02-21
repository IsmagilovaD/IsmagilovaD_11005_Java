package tuple;

public class ThreeTuple<A,B,C> {
    public final A first;
    public final B second;
    public final C thirst;

    public ThreeTuple(A first, B second, C thirst) {
        this.first = first;
        this.second = second;
        this.thirst = thirst;
    }
}
