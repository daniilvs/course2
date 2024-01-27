package ex_3_2_1.io;

public class ConsoleIO implements IO {
    @Override
    public void print(Object o) {
        System.out.println(o);
    }

    @Override
    public int readInt() {
        return 0;
    }
}
