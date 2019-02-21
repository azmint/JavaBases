package jp.personal.gi.java.bases.type;

import java.util.*;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public boolean isLessThan(Amount other) {
        return this.value < other.value;
    }

    public Amount add(Amount other) {
        return new Amount(this.value + other.value);
    }

    public Amount subtract(Amount other) {
        return new Amount(this.value - other.value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }
}
