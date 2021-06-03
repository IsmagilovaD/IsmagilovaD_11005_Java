package Task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WriterReader writerReader = new WriterReader(10);
        Thread t1 = new Thread(() -> {
            try {
                writerReader.writer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                writerReader.reader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
