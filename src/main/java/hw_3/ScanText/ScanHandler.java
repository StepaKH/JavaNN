package hw_3.ScanText;

import java.util.Scanner;

public class ScanHandler {

    private ScanHandler(){}

    public static String readLine(){
        Scanner scanner = new Scanner(System.in);
        String data = null;

        try {
            data = scanner.nextLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    // Хотел использовать, чтобы выводилось одно из трех вариантов: год, года или лет после колличества лет
    // Но у меня не получается настроить русскую кодировку, чтобы выводилось хорошо.
    // Метод должен был использоваться в методе analytics из класса AnalyticsHandler в самом конце, при выводе информации
    public static String getEnd(int years){
        if (years == 1) {
            return "год";
        } else if (years >= 2 && years <= 4) {
            return "года";
        } else if (years >= 5 && years <= 20) {
            return "лет";
        } else if (years % 10 == 1) {
            return "год";
        } else if (years % 10 >= 2 && years % 10 <= 4) {
            return "года";
        } else {
            return "лет";
        }
    }
}
