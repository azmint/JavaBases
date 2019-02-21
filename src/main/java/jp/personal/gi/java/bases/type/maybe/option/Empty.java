package jp.personal.gi.java.bases.type.maybe.option;

import jp.personal.gi.java.bases.type.maybe.list.*;

import java.util.*;
import java.util.function.*;

class Empty<T> implements Option<T> {
    private static final Empty INSTANCE = new Empty();

    private Empty() {
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Empty<T> object() {
        return INSTANCE;
    }

    @Override
    public T get() throws NoSuchElementException {
        throw new NoSuchElementException("Option is Empty");
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Option<T> ifPresent(Consumer<? super T> action) {
        return this;
    }

    @Override
    public Option<T> ifEmpty(Runnable runner) {
        runner.run();
        return this;
    }

    @Override
    public Option<T> filter(Predicate<? super T> predicate) {
        return this;
    }

    @Override
    public <R> Option<R> map(Function<? super T, R> mapper) {
        return object();
    }

    @Override
    public <R> Option<R> flatMap(Function<? super T, Option<R>> mapper) {
        return object();
    }

    @Override
    public T orElse(T other) {
        return other;
    }

    @Override
    public T orElseGet(Supplier<T> supplier) {
        return supplier.get();
    }

    @Override
    public <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X {
        throw supplier.get();
    }

    @Override
    public ReadOnlyList<T> toReadOnlyList() {
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.nonNull(obj)
                && obj instanceof Empty<?>;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }
}
