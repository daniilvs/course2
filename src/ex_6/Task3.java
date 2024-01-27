package ex_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Task3 implements Runnable {

    volatile boolean running = true;
    private int id;
    private long time;

    public Task3(int id, long time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread: " + id + " - Interrupted");
                break;
            }
            long end = System.currentTimeMillis();
            System.out.println("Thread: " + id + ", time: " + (end - time));
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}


class Task3Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService poolOfThreads = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();

        List<Future> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(poolOfThreads.submit(new Task3(i, start)));
        }

        Thread.sleep(5000);

        for (Future<?> item : list) {
            item.cancel(true);
        }

        poolOfThreads.shutdown();
        poolOfThreads.awaitTermination(1, TimeUnit.DAYS);
    }
}