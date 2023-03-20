package thread1.go1;

public class Main {

    private static void print(int max) throws InterruptedException {
        for (int i = 0; i < max; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.sleep(100);
        }
    }

    private static void go() {
        try {
            print(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {


        // Thread t1 = new Thread(() -> go());
        //Thread t1 = new Thread(() -> {
            //print(100);
        //});
        Thread t1 = new Thread(Main :: go);

        t1.start();

        //Thread.sleep(10);

        //t1.join();
        print(10);

        // targil:
        // each number should be printed once
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

    }
}
