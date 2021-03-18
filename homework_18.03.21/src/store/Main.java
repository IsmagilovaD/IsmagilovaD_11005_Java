package store;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        String[] str = {"Bob pen 5", "Bob pencil 3", "Mark book 2", "Mark book 3", "Bob book 1", "Mark pen 4"};

        for (String item : str) {
            String[] s = item.split(" ");
            Map<String, Integer> map1;
            if (map.containsKey(s[0])) {
                map1 = map.get(s[0]);
                if (map1.containsKey(s[1])) {
                    int value = map1.get(s[1]) + Integer.parseInt(s[2]);
                    map1.put(s[1], value);
                } else map1.put(s[1], Integer.parseInt(s[2]));

            } else {
                map1 = new HashMap<>();
                map1.put(s[1], Integer.parseInt(s[2]));

            }
            map.put(s[0], map1);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            Map<String,Integer> map1 = entry.getValue();
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                System.out.println("\t" + entry1.getKey() + " " + entry1.getValue());
            }
            System.out.println("-----------");
        }
    }
}
