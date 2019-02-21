package jp.personal.gi.java.bases.type.maybe.list;

import jp.personal.gi.java.bases.type.maybe.either.*;
import jp.personal.gi.java.bases.type.maybe.option.*;

import java.util.function.*;

public interface ReadOnlyList<E> extends Iterable<E> {
    Option<E> getOption(int index);

    <L> Either<L, E> getEither(int index, Supplier<L> leftSupplier);

    ReadOnlyList<E> addAll(ReadOnlyList<? extends E> other);

    <R> ReadOnlyList<R> map(Function<? super E, R> mapper);

    <L, R> Either<L, ReadOnlyList<R>> flatMapEither(Function<? super E, Either<L, R>> mapper);

    ReadOnlyList<ElementWithIndex<E>> zipWithIndex();
}
