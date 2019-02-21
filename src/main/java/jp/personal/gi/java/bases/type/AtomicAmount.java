package jp.personal.gi.java.bases.type;

import java.util.*;

public class AtomicAmount {
    private int value;

    public AtomicAmount(int value) {
        this.value = value;
    }

    public boolean isLessThan(AtomicAmount other) {
        return this.value < other.value;
    }

    public AtomicAmount addAndGet(AtomicAmount other) {
        this.value += other.value;
        return this;
    }

    public AtomicAmount subtract(AtomicAmount other) {
        return new AtomicAmount(this.value - other.value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AtomicAmount amount = (AtomicAmount) o;
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
