package hw_1.ComplexNumber;

public interface Operations {
    ComplexNumber add(ComplexNumber other);
    ComplexNumber subtract(ComplexNumber other);
    ComplexNumber multiply(ComplexNumber other);
    ComplexNumber divide(ComplexNumber other);
    double getArg();
    double getModule();
}
