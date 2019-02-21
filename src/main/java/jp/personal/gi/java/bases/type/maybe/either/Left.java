package jp.personal.gi.java.bases.type.maybe.either;

import jp.personal.gi.java.bases.type.maybe.list.*;
import jp.personal.gi.java.bases.type.maybe.option.*;

import java.util.function.*;

class Left<L, R> implements Either<L, R> {
    private final L value;

    public Left(L value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public Either<L, R> ifLeft(Consumer<? super L> action) {
        action.accept(value);
        return this;
    }

    @Override
    public Either<L, R> ifRight(Consumer<? super R> action) {
        return this;
    }

    @Override
    public <T> Either<L, T> map(Function<? super R, T> mapper) {
        return new Left<>(value);
    }

    @Override
    public <T> Either<L, T> flatMap(Function<? super R, Either<? extends L, T>> mapper) {
        return new Left<>(value);
    }

    @Override
    public <T> T fold(Function<? super L, T> leftMapper, Function<? super R, T> rightMapper) {
        return leftMapper.apply(value);
    }

    @Override
    public <X extends Throwable> R ifLeftThrow(Function<? super L, X> mapper) throws X {
        throw mapper.apply(this.value);
    }

    @Override
    public Option<R> toOption() {
        return Option.empty();
    }

    @Override
    public ReadOnlyList<R> toReadOnlyList() {
        return null;
    }
}
