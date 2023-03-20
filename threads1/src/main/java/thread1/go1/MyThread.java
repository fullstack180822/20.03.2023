package thread1.go1;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private String data;

    // not logical
    // private AtomicInteger counter = new AtomicInteger(1);

    public MyThread(String name, String data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(this.data);
        Utils.foo();
        MyThread mt = new MyThread("1", "2");
        mt.start();
    }

}
