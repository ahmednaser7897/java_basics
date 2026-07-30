package dateAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalenderClass {
    public static void main(String[] args) {
        testCalenderClass();
        System.out.println("=========================================");
        testFormatCalenderDate();
        System.out.println("=========================================");
        dateExample();
        System.out.println("=========================================");
        timeZoneExample();
        // System.out.println("=========================================");
        // zoneIdExample();
        System.out.println("=========================================");
        convertDateCalender();
    }

    private static void testCalenderClass() {
        System.out.println("Calendar Class");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println("Year: " + year + " Month: " + month + " Day: " + day + " Hour: " + hour
                + " Minute: " + minute + " Second: " + second);

    }

    private static void testFormatCalenderDate() {
        System.out.println("Formatting Calender Date");
        Calendar calendar = Calendar.getInstance();
        // DateTimeFormatter Pattern Rules

        // yyyy -> Year (e.g., 2026)
        // yy -> Last two digits of the year (e.g., 26)

        // MM -> Month in numbers with leading zero (01-12)
        // M -> Month in numbers without leading zero (1-12)

        // dd -> Day of month with leading zero (01-31)
        // d -> Day of month without leading zero (1-31)

        // DD -> Day of year (001-365 or 366)

        // HH -> Hour in 24-hour format (00-23)
        // H -> Hour in 24-hour format without leading zero

        // hh -> Hour in 12-hour format (01-12)
        // h -> Hour in 12-hour format without leading zero

        // mm -> Minute (00-59)

        // ss -> Second (00-59)

        // SSS -> Milliseconds (000-999)

        // E -> Day of week short name (Mon, Tue, Wed)
        // EEEE -> Full day of week (Monday, Tuesday)

        // a -> AM/PM

        // MMM -> Short month name (Jan, Feb, Mar)
        // MMMM -> Full month name (January, February)

        // z -> Time zone abbreviation (UTC, PST)
        // Z -> Time zone offset (+0200)
        // XXX -> ISO 8601 time zone offset (+02:00)

        // Example
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println(sdf2.format(calendar.getTime()));
        SimpleDateFormat sdf5 = new SimpleDateFormat("EEEE,dd-MM-yyyy HH:mm:ss a");
        System.out.println(sdf5.format(calendar.getTime()));

    }

    private static void dateExample() {
        try {
            System.out.println("Date Class");
            Date date = new Date(1988, 2, 1);
            Date date2 = new Date();
            Date date3 = new Date(1895215322137621581L);
            System.out.println(date);
            System.out.println(date2);
            System.out.println(date3);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            Date dateParsed = sdf.parse("1999/01/10 10:02:02");
            System.out.println(dateParsed);

            String dateString = sdf.format(dateParsed);
            System.out.println(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void timeZoneExample() {
        System.out.println("Time Zone Class");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date = new Date(1090215021581L);
        System.out.println(sdf.format(date));

        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+1")));
        System.out.println(sdf.format(date));
    }

    public static void zoneIdExample() {
        System.out.println("Zone Id Class");
        ZoneId.getAvailableZoneIds().stream()
                .forEach(System.out::println);
    }

    public static void convertDateCalender() {
        try {
            System.out.println("Convert Date Calender");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "22-01-2015 10:20:56";
            Date date = sdf.parse(dateInString);
            System.out.println("Date: " + date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            date = calendar.getTime();
            System.out.println("Date converted from Calendar: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
