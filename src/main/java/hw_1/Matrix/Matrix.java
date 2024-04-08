package hw_1.Matrix;
import hw_1.ComplexNumber.ComplexNumber;
import org.jetbrains.annotations.NotNull;
import hw_1.SetData.BasicOperations;

public class Matrix implements Operations{
    private int rows;
    private int cols;
    private ComplexNumber[][] matrix;

    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        matrix = new ComplexNumber[rows][cols];
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public void setElement(int i, int j, ComplexNumber value){
        if (i < 0 || i >= rows || j < 0 || j >= cols){
            throw new IndexOutOfBoundsException("Index is not within matrix boundaries");
        }
        matrix[i][j] = value;
    }

    public ComplexNumber getElement(int i, int j){
        if (i < 0 || i >= rows || j < 0 || j >= cols){
            throw new IndexOutOfBoundsException("Index is not within matrix boundaries");
        }
        return matrix[i][j].clone();
    }

    public Matrix add(@NotNull Matrix other){
        if (this.rows != other.rows || this.cols != other.cols){
            throw new IllegalArgumentException("Cannot stack matrices of different sizes");
        }
        Matrix new_Mat = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < other.cols; j++){
                new_Mat.matrix[i][j] = this.matrix[i][j].add(other.matrix[i][j]);
            }
        }
        return new_Mat;
    }

    public Matrix subtract(@NotNull Matrix other){
        if (this.rows != other.rows || this.cols != other.cols){
            throw new IllegalArgumentException("Cannot subtract matrices of different sizes");
        }
        Matrix new_Mat = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < other.cols; j++){
                new_Mat.matrix[i][j] = this.matrix[i][j].subtract(other.matrix[i][j]);
            }
        }
        return new_Mat;
    }

    public Matrix multiplyOnMatrix(@NotNull Matrix other){
        if (this.cols != other.rows){
            throw new IllegalArgumentException("Matrices cannot be multiplied because they have unacceptable sizes for this operation");
        }
        Matrix new_Mat = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < other.cols; j++){
                ComplexNumber sum = new ComplexNumber(0,0);
                for (int u = 0; u < this.cols; u++){
                    sum = sum.add(this.matrix[i][u].multiply(other.matrix[u][j]));
                }
                new_Mat.matrix[i][j] = sum;
            }
        }
        return new_Mat;
    }

    public Matrix multiplyOnNumber(ComplexNumber number){
        Matrix new_Mat = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.cols; j++){
                new_Mat.matrix[i][j] = this.matrix[i][j].multiply(number);
            }
        }
        return new_Mat;
    }

    public ComplexNumber determinant(){
        if (rows != cols){
            throw new UnsupportedOperationException("Determinant is defined only for square matrices");
        }
        ComplexNumber[][] arr = new ComplexNumber[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                arr[i][j] = new ComplexNumber(matrix[i][j].getReal(), matrix[i][j].getImaginary());
            }
        }
        ComplexNumber det = new ComplexNumber(1,0);
        for (int u = 0; u < rows - 1; u++){
            for (int i = u + 1; i < rows; i++){
                ComplexNumber res = arr[i][u].divide(arr[u][u]);
                for (int j = u+1; j < rows; j++){
                    arr[i][j] = arr[i][j].subtract(res.multiply(arr[u][j]));
                }
            }
            det = det.multiply(arr[u][u]);
        }
        det = det.multiply(arr[rows - 1][rows - 1]);
        return det;
    }

    public Matrix transpose(){
        Matrix new_Mat = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                new_Mat.matrix[j][i] = matrix[i][j];
            }
        }
        return new_Mat;
    }

    //Static Methods for Handling Exceptions
    private static void setData(Matrix source, Matrix destination) {
        destination.matrix = source.matrix;
        destination.rows = source.rows;
        destination.cols = source.cols;
    }

    public static void add(Matrix first, Matrix second, Matrix result) {
        boolean flag = true;
        try {
            Matrix.setData(first.add(second), result);
        } catch (IllegalArgumentException illegalArgumentException) {
            flag = false;
            System.out.print("Cannot stack matrices of different sizes\n");
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if (flag){
            System.out.println("\nResult:");
            BasicOperations.printMatrix(result);
        }
    }

    public static void subtract(Matrix first, Matrix second, Matrix result) {
        boolean flag = true;
        try {
            Matrix.setData(first.subtract(second), result);
        } catch (IllegalArgumentException illegalArgumentException) {
            flag = false;
            System.out.print("Cannot subtract matrices of different sizes\n");
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if (flag){
            System.out.println("\nResult:");
            BasicOperations.printMatrix(result);
        }
    }

    public static void multiplyOnMatrix(Matrix first, Matrix second, Matrix result) {
        boolean flag = true;
        try {
            Matrix.setData(first.multiplyOnMatrix(second), result);
        } catch (IllegalArgumentException illegalArgumentException) {
            flag = false;
            System.out.print("Matrices cannot be multiplied because they have unacceptable sizes for this operation\n");
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if (flag){
            System.out.println("\nResult:");
            BasicOperations.printMatrix(result);
        }
    }

    public static void multiplyOnNumber(Matrix matrix, ComplexNumber number, Matrix result) {
        boolean flag = true;
        try {
            Matrix.setData(matrix.multiplyOnNumber(number), result);
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if (flag){
            System.out.println("\nResult:");
            BasicOperations.printMatrix(result);
        }
    }

    public static void determinant(Matrix first, ComplexNumber result) {
        boolean flag = true;
        try {
            ComplexNumber temp = first.determinant();
            result.setReal(temp.getReal());
            result.setImaginary(temp.getImaginary());
        } catch (UnsupportedOperationException unsupportedOperationException) {
            flag = false;
            System.out.print("Determinant is defined only for square matrices\n");
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if (flag){
            System.out.println("\nResult:");
            BasicOperations.printComplexNumber(result);
        }
    }

    public static void transpose(Matrix first, Matrix result){
        boolean flag = true;
        try {
            Matrix.setData(first.transpose(), result);
        } catch (Exception exception) {
            flag = false;
            System.out.print("Something went wrong. Check arguments and try again\n");
        }
        if(flag){
            System.out.println("\nResult:");
            BasicOperations.printMatrix(result);
        }
    }
}
