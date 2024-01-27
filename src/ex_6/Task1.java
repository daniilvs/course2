package ex_6;

public class Task1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}

class Task1Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello from main thread");
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) threads[i] = new Task1();
        for (int i = 0; i < 10; i++) threads[i].start();
        for (int i = 0; i < 10; i++) threads[i].interrupt();
        for (int i = 0; i < 10; i++) threads[i].join();
    }
}