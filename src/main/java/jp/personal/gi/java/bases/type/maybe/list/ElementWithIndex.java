package jp.personal.gi.java.bases.type.maybe.list;

import java.util.*;
import java.util.function.*;

public class ElementWithIndex<E> {
    private final E element;
    private final int index;

    public ElementWithIndex(E element, int index) {
        this.element = element;
        this.index = index;
    }

    public E element() {
        return this.element;
    }

    public int index() {
        return this.index;
    }

    public <R> ElementWithIndex<R> map(Function<? super E, R> mapper) {
        return new ElementWithIndex<>(mapper.apply(this.element), this.index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ElementWithIndex<?> that = (ElementWithIndex<?>) o;
        return index == that.index &&
                Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, index);
    }

    @Override
    public String toString() {
        return "ElementWithIndex{" +
                "element=" + element +
                ", index=" + index +
                '}';
    }
}
