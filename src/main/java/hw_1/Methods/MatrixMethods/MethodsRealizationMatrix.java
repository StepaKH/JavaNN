package hw_1.Methods.MatrixMethods;
import hw_1.SetData.BasicOperations;
import hw_1.ComplexNumber.ComplexNumber;
import hw_1.Matrix.Matrix;

public class MethodsRealizationMatrix implements Methods{
    public void add() {
        System.out.println("\nDefine first matrix:");
        Matrix matrix1 = BasicOperations.getMatrix();
        System.out.println("\nDefine second matrix:");
        Matrix matrix2 = BasicOperations.getMatrix();
        Matrix res = new Matrix(matrix1.getRows(), matrix1.getCols());
        Matrix.add(matrix1, matrix2, res);
    }
    public void subtract() {
        System.out.println("\nSpecify reducible matrix:");
        Matrix matrix1 = BasicOperations.getMatrix();
        System.out.println("\nSpecify subtrahend matrix:");
        Matrix matrix2 = BasicOperations.getMatrix();
        Matrix res = new Matrix(matrix1.getRows(), matrix1.getCols());
        Matrix.subtract(matrix1,matrix2,res);
    }
    public void multiplyOnMatrix() {
        System.out.println("\nDefine first matrix:");
        Matrix matrix1 = BasicOperations.getMatrix();
        System.out.println("\nDefine second matrix:");
        Matrix matrix2 = BasicOperations.getMatrix();
        Matrix res = new Matrix(matrix1.getRows(), matrix2.getCols());
        Matrix.multiplyOnMatrix(matrix1,matrix2,res);
    }
    public void multiplyOnNumber() {
        System.out.println("\nDefine Matrix:");
        Matrix matrix = BasicOperations.getMatrix();
        System.out.println("\nSet the number:");
        ComplexNumber number = BasicOperations.getNumber();
        Matrix res = new Matrix(matrix.getRows(), matrix.getCols());
        Matrix.multiplyOnNumber(matrix,number,res);
    }
    public void determinant() {
        System.out.println("\nDefine Matrix:");
        Matrix matrix = BasicOperations.getMatrix();
        ComplexNumber res = new ComplexNumber(0,0);
        Matrix.determinant(matrix,res);
    }
    public void transpose() {
        System.out.println("\nDefine Matrix:");
        Matrix matrix = BasicOperations.getMatrix();
        Matrix res = new Matrix(matrix.getCols(), matrix.getRows());
        Matrix.transpose(matrix,res);
    }
}
