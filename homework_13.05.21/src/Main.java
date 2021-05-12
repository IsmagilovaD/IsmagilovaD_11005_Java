import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] str = {"asd", "lol", "kek", "apple", "asteroid", "alert", "array", "atmosphere"};
        List<String> list = task1(str);
        System.out.println("task1 : " + list);

//task2-----------------------------------------------------------------
        System.out.println("\ntask2 : ");
        Stream<Integer> stream = Stream.of(123, 231, 312, 312);
        stream.sorted(Comparator.comparingInt(x -> x % 10))
                .map(x -> x / 10)
                .distinct()
                .forEach(System.out::println);

//task3-----------------------------------------------------------------
        String[] s = new String[100];

        FileReader fr = new FileReader("task3.txt");
        Scanner scanner = new Scanner(fr);

        int i = 0;
        while (scanner.hasNextLine()) {
            s[i] = scanner.nextLine();
            i++;
        }

        Map<String, Integer> map = Arrays.stream(s).collect(Collectors.toMap(
                str1 -> str1.substring(0, str1.indexOf('|')),
                str1 -> Integer.parseInt(str1.substring(str1.indexOf('|') + 1)),
                (x, y) -> x = x + y));
        System.out.println("\ntask3 : " + map);
    }

    public static List<String> task1(String[] str) {
        return Arrays.stream(str).filter(x -> x.startsWith("a"))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}
