package jp.personal.gi.java.bases.type.maybe.either;

import jp.personal.gi.java.bases.type.maybe.list.*;
import jp.personal.gi.java.bases.type.maybe.option.*;

import java.util.function.*;

class Right<L, R> implements Either<L, R> {
    private final R value;

    public Right(R value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public Either<L, R> ifLeft(Consumer<? super L> action) {
        return this;
    }

    @Override
    public Either<L, R> ifRight(Consumer<? super R> action) {
        action.accept(value);
        return this;
    }

    @Override
    public <T> Either<L, T> map(Function<? super R, T> mapper) {
        return new Right<>(mapper.apply(value));
    }

    @Override
    public <T> Either<L, T> flatMap(Function<? super R, Either<? extends L, T>> mapper) {
        return mapper.apply(value).fold(Either::left, Either::right);
    }

    @Override
    public <T> T fold(Function<? super L, T> leftMapper, Function<? super R, T> rightMapper) {
        return rightMapper.apply(value);
    }

    @Override
    public <X extends Throwable> R ifLeftThrow(Function<? super L, X> mapper) throws X {
        return this.value;
    }

    @Override
    public Option<R> toOption() {
        return Option.of(this.value);
    }

    @Override
    public ReadOnlyList<R> toReadOnlyList() {
        return null;
    }
}
