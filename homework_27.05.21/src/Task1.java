public class Task1 {
    public static volatile long k = 1;

    public static void main(String[] args) throws InterruptedException {
        byte number = 8;

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            System.out.println(Thread.currentThread().getName() + " посчитал " + fourthOfFactorial(number, 1));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            System.out.println(Thread.currentThread().getName() + " посчитал " + fourthOfFactorial(number, 2));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            System.out.println(Thread.currentThread().getName() + " посчитал " + fourthOfFactorial(number, 3));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            System.out.println(Thread.currentThread().getName() + " посчитал " + fourthOfFactorial(number, 4));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Answer " + k);
    }

    public static long fourthOfFactorial(int n, int fourth) {
        if (fourth == 1) for (int i = 1; i < n / 4 + 1; i++) k = k * i;
        if (fourth == 2) for (int i = n / 4 + 1; i < n / 2 + 1; i++) k = k * i;
        if (fourth == 3) for (int i = n / 2 + 1; i < 3 * n / 4 + 1; i++) k = k * i;
        if (fourth == 4) for (int i = 3 * n / 4 + 1; i < n + 1; i++) k = k * i;
        return k;
    }
}

