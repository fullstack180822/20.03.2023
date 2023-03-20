package thread1.go1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

//    private static volatile int i = 0;
//
//    private static synchronized int get_counter_and_increment() {
//        return i++;
//    }

//    static int test = 0;
//    static int key = 0;
//    private static int get_counter_and_increment_test() {
//        synchronized (new Object()) {
//            return test++;
//        }
//    }

    private static AtomicInteger i = new AtomicInteger(-1);

    private static int get_counter_and_increment() {
        return i.getAndIncrement();
    }

    private static void print(int max) throws InterruptedException {

        // ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        int i = get_counter_and_increment();
        while (i < max) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.sleep(300);
            i = get_counter_and_increment();
        }
    }

    private static void go() {
        try {
            print(20);
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
        t1.setDaemon(true);
        Thread t2 = new Thread(Main :: go);
        //t2.setDaemon(true);

        t1.start();
        t2.start();

        //Thread.sleep(10);

        //t1.join();
        //go();

        // targil:
        // each number should be printed once
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        MyThread my1 = new MyThread("my-thread-1", "data1");
        my1.start();

        Utils.foo();

        System.out.println("thread main is done. goodbye");

    }
}
