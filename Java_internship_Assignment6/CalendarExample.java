import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Current date:");
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);

        calendar.add(Calendar.DAY_OF_MONTH, 15);

        int newYear = calendar.get(Calendar.YEAR);
        int newMonth = calendar.get(Calendar.MONTH) + 1;
        int newDay = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Date after adding 15 days:");
        System.out.println("Year: " + newYear);
        System.out.println("Month: " + newMonth);
        System.out.println("Day: " + newDay);
    }
}

