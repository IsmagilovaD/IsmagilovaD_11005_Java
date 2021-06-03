package Task2;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String[] symbols = {"abcdefghijklmnopqrstuvwxyz", "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"};

        int value = in.nextInt();
        if (value < 0) throw new InvalidParameterException("Вы ввели отрицательное число!");

        var executor = Executors.newScheduledThreadPool(4);

        for (int i = 0; i < value; i++) {
            executor.schedule(() -> {
                int language = random.nextInt(2);
                int numberOfSymbols = 1 + random.nextInt(5);
                for (int j = 0; j < numberOfSymbols; j++) {
                    char ch = symbols[language].charAt(random.nextInt(symbols[language].length()));
                    stringBuilder.append(ch);
                }
                System.out.println(Thread.currentThread().getName() + " has added new chars! \n" + stringBuilder);
            }, 3000, TimeUnit.MILLISECONDS);
        }
        executor.shutdown();
        if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            executor.shutdownNow();
        }
        System.out.println("The final result is " + stringBuilder);
    }
}
