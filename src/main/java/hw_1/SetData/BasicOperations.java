package hw_1.SetData;

import hw_1.ComplexNumber.ComplexNumber;
import hw_1.Matrix.Matrix;

import java.util.Scanner;

public class BasicOperations {
    private BasicOperations(){}

    private static double check(){
        double a;
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter valid number.");
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        a = scanner.nextDouble();
        return a;
    }

    public static ComplexNumber getNumber(){
        double first;
        double second = 0;
        int choice;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("To enter a real number, press 0\nTo enter a complex number, press 1");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter either 0 or 1.");
                System.out.print("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice != 0 && choice != 1) {
                System.out.println("Invalid input. Please enter either 0 or 1.");
            }
        } while (choice != 0 && choice != 1);

        if (choice == 0){
            System.out.print("Enter the number: ");
            first = check();
        }

        else{
            System.out.print("->complex number: a + bi. Insert a: ");
            first = check();

            System.out.print("->complex number: a + bi. Insert b: ");
            second = check();
        }

        return new ComplexNumber(first, second);
    }

    private static int checkM(){
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a natural number.");
                System.out.print("Enter a natural number: ");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Invalid input. Please enter a natural number greater than 0.");
            }
        } while (number <= 0);
        return number;
    }

    public static Matrix getMatrix(){
        int rows;
        int cols;

        System.out.print("->Insert rows count<-\n");
        rows = checkM();
        System.out.print("->Insert columns count<-\n");
        cols = checkM();
        System.out.println(rows + " " + cols);

        Matrix matrix = new Matrix(rows,cols);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print("\n->insert matrix element at i= " + i + " j= " + j + "\n");
                matrix.setElement(i, j, getNumber());
            }
        }
        return matrix;
    }

    public static void printComplexNumber(ComplexNumber number){
        System.out.println(number.getReal() + "+i*" + number.getImaginary() + "\n");
    }

    public static void printMatrix(Matrix matrix){
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getCols(); j++){
                System.out.print(matrix.getElement(i, j).getReal() + "+i*" + matrix.getElement(i, j).getImaginary() + " ");
            }
            System.out.println("\n");
        }
    }
}
