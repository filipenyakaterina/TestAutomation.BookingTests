package formatter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    private static final String DATE_FORMAT = "EEEE d MMMM yyyy";
    private static final String DATE_TIME_FORMAT = "uuuu-MM-dd_HH-mm-ss";
    private static final String DATE_FORMAT_WITH_COMMA = "EEEE, MMMM d, yyyy";
    private static final String COMMA = ",";

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return ZonedDateTime.now().format(formatter);
    }

    public static LocalDate getDateFromStringWithDayOfWeek(String calendarDateValue) {
        if (calendarDateValue.contains(COMMA)) {
            return parseLocalDateWithFormat(calendarDateValue, DATE_FORMAT_WITH_COMMA);
        } else {
            return parseLocalDateWithFormat(calendarDateValue, DATE_FORMAT);
        }
    }

    private static LocalDate parseLocalDateWithFormat(String dateValue, String format) {
        return LocalDate.parse(dateValue, DateTimeFormatter.ofPattern(format));
    }
}
