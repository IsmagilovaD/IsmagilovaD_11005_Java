package Task1;

import java.io.*;
import java.util.ArrayList;

public class WriterReader {
    ArrayList<Person> people = new ArrayList<>();
    boolean flag = false;
    private final File file = new File("src/Task1/people.txt");
    int count;

    public WriterReader(int count) {
        this.count = count;
    }

    public void writer() throws InterruptedException {
        RandomPersonCreater creater = new RandomPersonCreater();
        while (count > 0) {
            synchronized (this) {
                while (flag)
                    wait();
                count--;
                people.add(creater.createRandomPerson());
                serialize();
                System.out.println("Writer successfully wrote");
                flag = true;
                notify();
            }
        }
    }

    public void serialize() {
        try (FileOutputStream fileOut =
                     new FileOutputStream(file);
             ObjectOutputStream outputStream =
                     new ObjectOutputStream(fileOut)) {
            outputStream.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reader() throws InterruptedException {
        while (count > 0) {
            synchronized (this) {
                while (!flag)
                    wait();
                deserialize();
                System.out.println("Person [" + people.get(people.size() - 1).toString() + "]");
                flag = false;
                notify();
            }
        }
    }

    public void deserialize() {
        var people = getArray();
    }

    public ArrayList<Person> getArray() {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(file);
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(fileInputStream);
            var list = (ArrayList<Person>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
