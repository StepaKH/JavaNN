package hw_1.Methods.ComplexNumberMethods;
import java.util.Scanner;
import hw_1.Methods.SelectAnEntity.Entity;

public class MethodsInference{
    public static void methodInference(){
        Scanner scanner = new Scanner(System.in);
        MethodsRealization methods = new MethodsRealization();

        do {
            System.out.println("\nChoose what you want to do with complex numbers:");
            System.out.println("1. Add two numbers");
            System.out.println("2. Subtract one number from another");
            System.out.println("3. Multiply two numbers");
            System.out.println("4. Divide one number by another");
            System.out.println("5. Take number argument");
            System.out.println("6. Take the modulus of a number");
            System.out.println("7. Print the trigonometric form of a number");
            System.out.println("8. Come back");
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
                        methods.multiply();
                        break;
                    case 4:
                        methods.divide();
                        break;
                    case 5:
                        methods.getArg();
                        break;
                    case 6:
                        methods.getModule();
                        break;
                    case 7:
                        methods.printComplexNumberInTrigForm();
                        break;
                    case 8:
                        System.out.print("\n");
                        Entity.entity();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter from 1 to 8.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Считываем и игнорируем неверный ввод
            }
        }while(true);
    }
}
