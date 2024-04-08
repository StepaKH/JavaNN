package hw_1.Methods.MatrixMethods;
import java.util.Scanner;
import hw_1.Methods.SelectAnEntity.Entity;

public class MethodsInferenceMatrix {
    public static void methodInference(){
        Scanner scanner = new Scanner(System.in);
        MethodsRealizationMatrix methods = new MethodsRealizationMatrix();

        do {
            System.out.println("\nChoose what you want to do with complex matrices:");
            System.out.println("1. Add two matrices");
            System.out.println("2. Subtract one matrix from another");
            System.out.println("3. Multiply two matrices");
            System.out.println("4. Multiply matrix by number");
            System.out.println("5. Find the determinant of the matrix");
            System.out.println("6. Transpose matrix");
            System.out.println("7. Come back");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        methods.add();
                        break;
                    case 2:
                        methods.subtract();
                        break;
                    case 3:
                        methods.multiplyOnMatrix();
                        break;
                    case 4:
                        methods.multiplyOnNumber();
                        break;
                    case 5:
                        methods.determinant();
                        break;
                    case 6:
                        methods.transpose();
                        break;
                    case 7:
                        System.out.print("\n");
                        Entity.entity();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter from 1 to 7.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Считываем и игнорируем неверный ввод
            }
        }while(true);
    }
}
