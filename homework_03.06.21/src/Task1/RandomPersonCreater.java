package Task1;

import java.util.Random;

public class RandomPersonCreater {
    public Person createRandomPerson() {
        return new Person(createRandomName(), createRandomAge(), createRandomCountry());
    }

    private String createRandomName() {
        char[] chars = new char[10];
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int id = 0; id < 10; id++) {
            chars[id] = symbols.charAt(new Random().nextInt(symbols.length()));

        }
        return new String(chars);
    }

    private int createRandomAge() {
        return new Random().nextInt(100);
    }

    private Countries createRandomCountry() {
        return Countries.values()[new Random().nextInt(Countries.values().length)];
    }

}
