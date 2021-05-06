import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length));
        set.add("bottle");
        set.add("cat");
        set.add("a");
        set.add("metamorphosis");
        System.out.println("task 1 : " + set);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(177013);
        arrayList.add(-8);
        arrayList.add(-123);
        arrayList.add(-4);
        arrayList.add(4323);

        ArrayList<Integer> lessThanZero = siftArray(arrayList, x -> x < 0);
        ArrayList<Integer> oddNumbers = siftArray(arrayList, x -> x % 2 != 0);

        System.out.println("task 2 : " + lessThanZero);
        System.out.println("\t\t" + oddNumbers);
    }

    public static ArrayList<Integer> siftArray(ArrayList<Integer> list, Predicate<Integer> predicate) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : list) {
            if (predicate.test(x))
                result.add(x);
        }
        return result;
    }
}

