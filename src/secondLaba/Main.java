package secondLaba;

public class Main {
    final static Complex first = new Complex(2.0, 3.5);
    final static Complex second = new Complex(1.5, 0.5);
    final static Complex firstCopy = new Complex(2.0, 3.5);

    public static void main(String[] args) {
        Complex sample = new Complex();
        sample.real = 1.5;
        sample.imag = 0.5;
        System.out.println(sample);
        System.out.println(Complex.add(first, second));
        System.out.println(Complex.subtract(first, second));
        System.out.println(Complex.multiply(first, second));
        System.out.println(Complex.divide(first, second));
        System.out.println(first.equals(second));
        System.out.println(first.equals(firstCopy));
    }

}
