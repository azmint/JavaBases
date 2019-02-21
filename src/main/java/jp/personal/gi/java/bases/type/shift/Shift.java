package jp.personal.gi.java.bases.type.shift;

import jp.personal.gi.java.bases.type.date.*;

public enum Shift {
    First(Hour.of(07)),
    Second(Hour.of(15)),
    Third(Hour.of(22)),
    ;

    private final Hour hour;

    private Shift(Hour hour) {
        this.hour = hour;
    }

    public Hour hour() {
        return this.hour;
    }
}
