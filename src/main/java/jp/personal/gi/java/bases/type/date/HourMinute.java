package jp.personal.gi.java.bases.type.date;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class HourMinute {
    private static final String PATTERN = "HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    private final LocalTime localTime;

    private HourMinute(LocalTime localTime) {
        this.localTime = localTime;
    }

    public static HourMinute of(int hour, int minute) {
        return new HourMinute(LocalTime.of(hour, minute));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HourMinute that = (HourMinute) o;
        return Objects.equals(localTime, that.localTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localTime);
    }

    @Override
    public String toString() {
        return "HourMinute{" +
                "localTime=" + localTime +
                '}';
    }
}
