import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Availability {
    private List<Time_Date> bookedDates;

    public Availability() {
        bookedDates = new ArrayList<>();
    }

    public boolean isDateAvailable(Time_Date date) {
        for (Time_Date bookedDate : bookedDates) {
            if (bookedDate.getDay() == date.getDay() && bookedDate.getMonth() == date.getMonth() &&
                    bookedDate.getYear() == date.getYear() && bookedDate.getHour() == date.getHour() &&
                    bookedDate.getMinute() == date.getMinute()) {
                return false;
            }
        }
        return true;
    }

    public void bookDate(Time_Date date) {
        bookedDates.add(date);
    }

    public Time_Date getUniqueDate(Scanner scanner) {
        System.out.println("Enter pick-up day:");
        System.out.print("Day: ");
        int day = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.println("Hour [24 time]: ");
        int hour = scanner.nextInt();
        System.out.println("Min: ");
        int min = scanner.nextInt();

        Time_Date timeDate = new Time_Date(day, month, year, hour, min);
        while (!isDateAvailable(timeDate)) {
            System.out.println("The selected date is already booked. Please enter a new date.");
            System.out.println("Enter pick-up day:");
            System.out.print("Day: ");
            day = scanner.nextInt();
            System.out.print("Month: ");
            month = scanner.nextInt();
            System.out.print("Year: ");
            year = scanner.nextInt();
            System.out.println("Hour [24 time]: ");
            hour = scanner.nextInt();
            System.out.println("Min: ");
            min = scanner.nextInt();
            timeDate = new Time_Date(day, month, year, hour, min);
        }

        return timeDate;
    }
}