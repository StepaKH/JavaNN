package hw_3.Analytics;

import hw_3.ScanText.ScanHandler;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AnalyticsHandler {

    public AnalyticsHandler(){}

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;

    private void getUserData(String data){
        try {
            String[] arr = data.split(" ");
            surname = arr[0];
            name = arr[1];
            patronymic = arr[2];
            birthDay = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }catch (Exception e){
            System.out.println("Invalid input. Please enter data in the format \"Last_Name First_Name Patronymic DD.MM.YYYY\".");
            getUserData(ScanHandler.readLine());
        }
    }

    private String getGender(String patronymic) {
        if (patronymic.endsWith("ич") || patronymic.endsWith("ович") || patronymic.endsWith("евич")) {
            return "man";
        } else if (patronymic.endsWith("на") || patronymic.endsWith("евна") || patronymic.endsWith("овна")) {
            return "woman";
        } else {
            // В случае неопределенности (например, если нет отчества или нет соответствующих суффиксов),
            return "unknown";
        }
    }

    public void analytics(){
        System.out.println("Enter data in the format \"Last_Name First_Name Patronymic DD.MM.YYYY\":");
        String data = ScanHandler.readLine();
        getUserData(data);


        Period age = Period.between(birthDay, LocalDate.now());
        int years = age.getYears();
        String initials = name.charAt(0) + "." + patronymic.charAt(0) +".";
        //Здесь должен был использоваться метод getEnd
        System.out.println(surname + " " + initials + " - " + years + " " + ScanHandler.getEnd(years));
        System.out.println("Пол - " + getGender(patronymic));
    }
}
