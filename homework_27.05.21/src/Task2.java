import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> chet = new ArrayList<>();
        ArrayList<String> nechet = new ArrayList<>();

        ArrayList<String> main = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split(" ");
                for (String value : str) main.add(value.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Thread evenT = new Thread(() -> main.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 == 0) {
                chet.add(x);
                System.out.println(Thread.currentThread().getName() + " added word " + x + " to even list");
            }
        }));

        Thread oddT = new Thread(() -> main.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 != 0) {
                nechet.add(x);
                System.out.println(Thread.currentThread().getName() + " added word " + x + " to odd list");
            }
        }));

        evenT.start();
        oddT.start();

        evenT.join();
        oddT.join();

        System.out.println("\n" + chet + "\n");
        System.out.println(nechet);
    }
}
