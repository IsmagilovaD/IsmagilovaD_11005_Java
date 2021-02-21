package rangeInterval;

public class Main {

    public static void main(String[] args) {


        RangeInterval range = new RangeInterval(2, 6);
        Iterator<Integer> iterator = range.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());;
    }
}
