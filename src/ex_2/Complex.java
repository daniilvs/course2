package ex_2;

public class Complex {
    private double real;
    private double imag;

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

    public Complex add(Complex num2) {
        return new Complex((this.real + num2.real), (this.imag + num2.imag));
    }

    public Complex subtract(Complex num2) {
        return new Complex((this.real - num2.real), (this.imag - num2.imag));
    }

    public Complex multiply(Complex num2) {
        double newA = (this.real * num2.real - this.imag * num2.imag);
        double newB = (this.real * num2.imag + this.imag * num2.real);
        return new Complex(newA, newB);
    }

    public Complex divide(Complex num2) {
        double newA = (this.real * num2.real + this.imag * num2.imag) / ((num2.real * num2.real) + (num2.imag * num2.imag));
        double newB = (this.imag * num2.real - this.real * num2.imag) / ((num2.real * num2.real) + (num2.imag * num2.imag));
        return new Complex(newA, newB);
    }
}
