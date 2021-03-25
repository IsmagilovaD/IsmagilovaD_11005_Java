import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       StorageOfBuyers storage = new StorageOfBuyers();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split("\\|");
                storage.addOrder(str[0], str[1], str[2], Integer.parseInt(str[3]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       // System.out.println(storage.buyers.get(0));
       storage.printAll();

        storage.nameSort();
        storage.ordersCountSort();
    }
}

