package dictonary;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<String,Integer>();
        String str = "Peter Piper picked a peck of pickled peppers " +
                "A peck of pickled peppers Peter Piper picked " +
                "If Peter Piper picked a peck of pickled peppers " +
                "Where's the peck of pickled peppers Peter Piper picked";
        str = str.toLowerCase();
        str = str.replaceAll("\\p{P}", "");
        String[] s = str.split(" ");
        for (String key : s) {
            if (map.containsKey(key)) {
                int v = map.get(key) + 1;
                map.put(key, v);
            } else map.put(key, 1);
        }

        for(Map.Entry<String, Integer> item : map.entrySet()){
            System.out.printf("Word: %s \t\t\t Number: %d \n", item.getKey(), item.getValue());
        }
    }
}
