package jp.personal.gi.java.bases.type.tuple;

import java.util.*;
import java.util.function.*;

public class Pair<A, B> {
    private final A _1;
    private final B _2;

    private Pair(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    public <T> Pair<T, B> map_1(Function<? super A, T> mapper) {
        return new Pair<>(mapper.apply(_1), _2);
    }

    public <T> Pair<A, T> map_2(Function<? super B, T> mapper) {
        return new Pair<>(_1, mapper.apply(_2));
    }

    public <T, U> U fold(Function<? super A, T> mapper_1, Function<? super B, T> mapper_2, BiFunction<T, T, U> aggregator) {
        return aggregator.apply(mapper_1.apply(_1), mapper_2.apply(_2));
    }

    public Pair<B, A> swap() {
        return new Pair<>(_2, _1);
    }

    public A _1() {
        return _1;
    }

    public B _2() {
        return _2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(_1, pair._1) &&
                Objects.equals(_2, pair._2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                '}';
    }
}
