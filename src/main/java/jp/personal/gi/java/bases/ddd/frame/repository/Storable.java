package jp.personal.gi.java.bases.ddd.frame.repository;

import jp.personal.gi.java.bases.ddd.frame.entity.Entity;

import java.util.stream.Stream;

public interface Storable<E extends Entity<?>> {
    void store(E entity);

    void storeAll(Stream<? extends E> entities);
}
