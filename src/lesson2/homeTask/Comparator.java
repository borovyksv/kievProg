package lesson2.homeTask;

import java.util.Date;

/**
 * Created by user-pc on 17.06.2016.
 */
public class Comparator {
    // Метод compare возвращает true, если первый параметр @date находится в промежутке
    // между параметрами @from и @to текущей даты (сегодняшнего дня)
    public static boolean compare(Date date, String from, String to) {
        Date fromDate = new Date();
        Date toDate = new Date();
        try {
            String[] fromSplit = from.split(":");
            fromDate.setHours(Integer.parseInt(fromSplit[0]));
            fromDate.setMinutes(Integer.parseInt(fromSplit[1]));
            String[] toSplit = to.split(":");
            toDate.setHours(Integer.parseInt(toSplit[0]));
            toDate.setMinutes(Integer.parseInt(toSplit[1]));
            if (date.after(fromDate)&&date.before(toDate)) return true;

        } catch (Exception e) {
            System.err.println("Illegal argument in compare method");
            e.printStackTrace();
        }
        return false;
    }
}
