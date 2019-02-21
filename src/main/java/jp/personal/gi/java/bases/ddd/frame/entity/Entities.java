package jp.personal.gi.java.bases.ddd.frame.entity;

import jp.personal.gi.java.bases.ddd.frame.Specification;

import java.util.Iterator;

public interface Entities<E extends Entity, T extends Entities<E, T>> extends Iterable<E> {
    T filterBy(Specification<? super E> specification);

    @Override
    Iterator<E> iterator();
}
