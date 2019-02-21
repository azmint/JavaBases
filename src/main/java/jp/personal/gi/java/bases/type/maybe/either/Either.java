package jp.personal.gi.java.bases.type.maybe.either;

import jp.personal.gi.java.bases.type.maybe.list.*;
import jp.personal.gi.java.bases.type.maybe.option.*;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Either<L, R> {
    static <L, R> Either<L, R> right(R right) {
        return null;
    }

    static <L, R> Either<L, R> left(L left) {
        return null;
    }

    static <L, R> Either<L, R> of(Optional<L> maybeLeft, Supplier<R> rightSupplier) {
        return maybeLeft
                .map(Either::<L, R>left)
                .orElseGet(() -> Either.right(rightSupplier.get()));
    }

    static <L, R> Either<L, R> of(Supplier<L> leftSupplier, Optional<R> maybeRight) {
        return maybeRight
                .map(Either::<L, R>right)
                .orElseGet(() -> Either.left(leftSupplier.get()));
    }

    boolean isLeft();

    boolean isRight();

    Either<L, R> ifLeft(Consumer<? super L> action);

    Either<L, R> ifRight(Consumer<? super R> action);

    <T> Either<L, T> map(Function<? super R, T> mapper);

    <T> Either<L, T> flatMap(Function<? super R, Either<? extends L, T>> mapper);

    <T> T fold(Function<? super L, T> leftMapper, Function<? super R, T> rightMapper);

    <X extends Throwable> R ifLeftThrow(Function<? super L, X> mapper) throws X;

    Option<R> toOption();

    ReadOnlyList<R> toReadOnlyList();
}
