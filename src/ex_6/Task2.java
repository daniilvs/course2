package ex_6;

public class Task2 extends Thread {
    @Override
    public void run() {
        double t = System.nanoTime();
        try{
            while(!isInterrupted()){
                Thread.sleep(1000);
                System.out.println(getName() + " started " + ((System.nanoTime()) - t) * Math.pow(10, -9) + " s ago");
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted after " + (System.nanoTime() - t) * Math.pow(10, -9) + " s");
        }
    }
}

class Task2Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) new Task2().start();
    }
}
