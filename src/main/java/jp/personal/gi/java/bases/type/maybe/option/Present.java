package jp.personal.gi.java.bases.type.maybe.option;

import jp.personal.gi.java.bases.type.maybe.list.*;

import java.util.*;
import java.util.function.*;

class Present<T> implements Option<T> {
    private final T value;

    public Present(T value) {
        this.value = value;
    }

    @Override
    public T get() throws NoSuchElementException {
        return this.value;
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Option<T> ifPresent(Consumer<? super T> action) {
        action.accept(this.value);
        return this;
    }

    @Override
    public Option<T> ifEmpty(Runnable runner) {
        return this;
    }

    @Override
    public Option<T> filter(Predicate<? super T> predicate) {
        return predicate.test(this.value)
                ? this
                : Empty.object();
    }

    @Override
    public <R> Option<R> map(Function<? super T, R> mapper) {
        return new Present<>(mapper.apply(this.value));
    }

    @Override
    public <R> Option<R> flatMap(Function<? super T, Option<R>> mapper) {
        return mapper.apply(this.value);
    }

    @Override
    public T orElse(T other) {
        return this.value;
    }

    @Override
    public T orElseGet(Supplier<T> supplier) {
        return this.value;
    }

    @Override
    public <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X {
        return this.value;
    }

    @Override
    public ReadOnlyList<T> toReadOnlyList() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Present<?> present = (Present<?>) o;
        return Objects.equals(value, present.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Present{" +
                "value=" + value +
                '}';
    }
}
