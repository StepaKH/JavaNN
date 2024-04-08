package hw_1.ComplexNumber;

public class ComplexNumber implements Operations, Cloneable{
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other){
        if (other == null){
            throw new IllegalArgumentException("New argument cannot be null");
        }
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }


    public ComplexNumber subtract(ComplexNumber other){
        if (other == null){
            throw new IllegalArgumentException("New argument cannot be null");
        }
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other){
        if (other == null){
            throw new IllegalArgumentException("New argument cannot be null");
        }
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other){
        if (other == null){
            throw new IllegalArgumentException("New argument cannot be null");
        }
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary)/denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary)/denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public double getArg(){
        return Math.atan2(imaginary, real);
    }

    public double getModule(){
        return Math.sqrt(real*real + imaginary*imaginary);
    }

    public double getImaginary() {
        return imaginary;
    }
    public double getReal() {
        return real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    public void setReal(double real) {
        this.real = real;
    }

    @Override
    public ComplexNumber clone() {
        return new ComplexNumber(real, imaginary);
    }
}
