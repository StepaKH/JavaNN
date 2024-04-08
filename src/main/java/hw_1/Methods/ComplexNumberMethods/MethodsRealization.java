package hw_1.Methods.ComplexNumberMethods;
import hw_1.SetData.BasicOperations;
import hw_1.ComplexNumber.ComplexNumber;

public class MethodsRealization implements Methods{
    public void add() {
        System.out.println("\nEnter the first number:");
        ComplexNumber number1 = BasicOperations.getNumber();
        System.out.println("\nEnter the second number:");
        ComplexNumber number2 = BasicOperations.getNumber();
        ComplexNumber res = number1.add(number2);
        System.out.println("\nResult:");
        BasicOperations.printComplexNumber(res);
    }
    public void subtract() {
        System.out.println("\nEnter the first number:");
        ComplexNumber number1 = BasicOperations.getNumber();
        System.out.println("\nEnter the second number:");
        ComplexNumber number2 = BasicOperations.getNumber();
        ComplexNumber res = number1.subtract(number2);
        System.out.println("\nResult:");
        BasicOperations.printComplexNumber(res);
    }
    public void multiply() {
        System.out.println("\nEnter the first number:");
        ComplexNumber number1 = BasicOperations.getNumber();
        System.out.println("\nEnter the second number:");
        ComplexNumber number2 = BasicOperations.getNumber();
        ComplexNumber res = number1.multiply(number2);
        System.out.println("\nResult:");
        BasicOperations.printComplexNumber(res);
    }
    public void divide() {
        System.out.println("\nEnter the first number:");
        ComplexNumber number1 = BasicOperations.getNumber();
        System.out.println("\nEnter the second number:");
        ComplexNumber number2 = BasicOperations.getNumber();
        ComplexNumber res = number1.divide(number2);
        System.out.println("\nResult:");
        BasicOperations.printComplexNumber(res);
    }
    public void getArg() {
        System.out.println("\nEnter the number:");
        ComplexNumber number = BasicOperations.getNumber();
        if (number.getReal() == 0){
            System.out.print("The real part cannot be equal to 0\n");
        }
        else {
            double res = number.getArg();
            System.out.println("\nResult:");
            System.out.println(res);
        }
    }
    public void getModule() {
        System.out.println("\nEnter the number:");
        ComplexNumber number = BasicOperations.getNumber();
        double res = number.getModule();
        System.out.println("\nResult:");
        System.out.println(res);
    }
    public void printComplexNumberInTrigForm() {
        System.out.println("\nEnter the number:");
        ComplexNumber number = BasicOperations.getNumber();
        double magnitude = number.getModule();
        double angle = number.getArg();
        System.out.println("\nResult:");
        System.out.print(magnitude + " * (cos(" + angle + ") + i*sin(" + angle + "))\n");
    }
}
