package secondLaba;

import static java.lang.Math.pow;

public class Complex {
    double real;
    double imag;

    public Complex() {}

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(real, complex.real) == 0 && Double.compare(imag, complex.imag) == 0;
    }

    public static Complex add(Complex num1, Complex num2) {
        return new Complex((num1.real + num2.real), (num1.imag + num2.imag));
    }

    public static Complex subtract(Complex num1, Complex num2) {
        return new Complex((num1.real - num2.real), (num1.imag - num2.imag));
    }

    public static Complex multiply(Complex num1, Complex num2) {
        double newA = (num1.real * num2.real - num1.imag * num2.imag);
        double newB = (num1.real * num2.imag + num1.imag * num2.real);
        return new Complex(newA, newB);
    }

    public static Complex divide(Complex num1, Complex num2) {
        double newA = (num1.real * num2.real + num1.imag * num2.imag) / (pow(num2.real, 2) + pow(num2.imag, 2));
        double newB = (num1.imag * num2.real - num1.real * num2.imag) / (pow(num2.real, 2) + pow(num2.imag, 2));
        return new Complex(newA, newB);
    }
}
