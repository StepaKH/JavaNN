package hw_1.Matrix;
import hw_1.ComplexNumber.ComplexNumber;


public interface Operations {
    void setElement(int i, int j, ComplexNumber value);
    ComplexNumber getElement(int i, int j);
    Matrix add(Matrix other);
    Matrix subtract(Matrix other);
    Matrix multiplyOnMatrix(Matrix other);
    Matrix multiplyOnNumber(ComplexNumber number);
    ComplexNumber determinant();
    Matrix transpose();
}
