import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        while (true) {
            byte ans = in.nextByte();
            switch (ans) {
                case 0:
                    return;
                case 1:
                    Thread t1 = new Thread(Main::task1);
                    break;
                case 2:
                    Thread t2 = new Thread(Main::task2);
                    break;
                case 3:
                    Thread t3 = new Thread(Main::task3);
                    break;
                default:
                    break;
            }
        }
    }

    public static void task1() {
        HashMap<String, HashMap<String, Integer>> map1 = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("task1.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void task2() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("task2.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        var r = list.stream().map(x -> Integer.parseInt(x.substring(x.indexOf("\\|") + 1)))
                .reduce(Integer::sum);

        var l = list.stream().collect(Collectors
                .groupingBy(x -> x.substring(0, x.indexOf("\\|")),
                        Collectors.mapping(x -> Integer.parseInt(x.substring(x.indexOf("\\|") + 1)),
                                Collectors.reducing(0, Integer::sum))))
                .entrySet().size();
        var average = r.get() / l;

        var ans = list.stream().collect(Collectors
                .groupingBy(x -> x.substring(0, x.indexOf("\\|")),
                        Collectors.mapping(x -> Integer.parseInt(x.substring(x.indexOf("\\|") + 1)),
                                Collectors.reducing(0, Integer::sum))))
                .entrySet().stream()
                .filter(x -> x.getValue() > average);
        System.out.println(ans);
    }

    public static void task3() {
    }

}
