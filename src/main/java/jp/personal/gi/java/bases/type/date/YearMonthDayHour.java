package jp.personal.gi.java.bases.type.date;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class YearMonthDayHour {
    private static final String PATTERN = "yyyy/MM/dd HH";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    private final LocalDateTime localDateTime;

    private YearMonthDayHour(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public static YearMonthDayHour from(LocalDateTime localDateTime) {
        final LocalDateTime yearMonthDayHour = LocalDateTime.of(
                localDateTime.getYear(),
                localDateTime.getMonth(),
                localDateTime.getDayOfMonth(),
                localDateTime.getHour(),
                0);
        return new YearMonthDayHour(yearMonthDayHour);
    }

    public static YearMonthDayHour now() {
        return from(LocalDateTime.now());
    }

    public String format(DateTimeFormatter formatter) {
        return this.localDateTime.format(formatter);
    }

    public LocalDateTime toLocalDateTime() {
        return this.localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final YearMonthDayHour that = (YearMonthDayHour) o;
        return Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDateTime);
    }

    @Override
    public String toString() {
        return "YearMonthDayHour{" +
                this.localDateTime.format(FORMATTER) +
                '}';
    }
}
