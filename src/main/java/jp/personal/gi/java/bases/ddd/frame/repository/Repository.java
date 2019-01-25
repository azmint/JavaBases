package jp.personal.gi.java.bases.ddd.frame.repository;

import jp.personal.gi.java.bases.ddd.frame.entity.Entity;
import jp.personal.gi.java.bases.ddd.frame.entity.EntityId;

import java.util.Optional;
import java.util.stream.Stream;

public interface Repository<T extends EntityId, E extends Entity<T>> {
    Optional<E> findBy(T id);

    Stream<E> findAll();

    boolean isEmpty();

    default boolean isPresent() {
        return !isEmpty();
    }
}
