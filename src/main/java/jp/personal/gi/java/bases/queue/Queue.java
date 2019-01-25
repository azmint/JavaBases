package jp.personal.gi.java.bases.queue;

import java.util.List;
import java.util.Optional;

public interface Queue<E> {
    boolean push(E element);

    Optional<E> pop();

    Optional<E> head();

    Optional<E> tail();

    boolean deleteHead();

    List<E> toList();
}
