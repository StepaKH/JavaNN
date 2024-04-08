package hw_1.Methods.SelectAnEntity;

import hw_1.Methods.ComplexNumberMethods.MethodsInference;
import hw_1.Methods.MatrixMethods.MethodsInferenceMatrix;
import java.util.Scanner;

public class Entity {
    public static void entity(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        do {
            System.out.println("Choose what you want to operate with:");
            System.out.println("1. Matrices");
            System.out.println("2. Complex numbers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if(scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                // Обработка выбора
                if (choice == 1) {
                    MethodsInferenceMatrix.methodInference();
                } else if (choice == 2) {
                    MethodsInference.methodInference();
                } else if (choice == 3) {
                    flag = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2 or 3.\n");
                }
            } else {
                // Если введено не число
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Считываем и игнорируем неверный ввод
            }
        }while(!flag);

        scanner.close();
    }
}
