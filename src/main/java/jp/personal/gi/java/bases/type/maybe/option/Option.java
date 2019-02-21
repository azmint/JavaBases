package jp.personal.gi.java.bases.type.maybe.option;

import jp.personal.gi.java.bases.type.maybe.list.*;

import java.util.*;
import java.util.function.*;

public interface Option<T> {
    static <T> Option<T> of(T value) {
        return new Present<>(value);
    }

    static <T> Option<T> ofNullable(T value) {
        return Objects.nonNull(value)
                ? of(value)
                : empty();
    }

    static <T> Option<T> empty() {
        return new Empty<>();
    }

    T get() throws NoSuchElementException;

    boolean isPresent();

    boolean isEmpty();

    Option<T> ifPresent(Consumer<? super T> action);

    Option<T> ifEmpty(Runnable runner);

    Option<T> filter(Predicate<? super T> predicate);

    <R> Option<R> map(Function<? super T, R> mapper);

    <R> Option<R> flatMap(Function<? super T, Option<R>> mapper);

    T orElse(T other);

    T orElseGet(Supplier<T> supplier);

    <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X;

    ReadOnlyList<T> toReadOnlyList();

    @Override
    int hashCode();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();
}
