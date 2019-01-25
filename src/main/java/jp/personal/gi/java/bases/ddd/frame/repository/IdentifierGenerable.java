package jp.personal.gi.java.bases.ddd.frame.repository;

import jp.personal.gi.java.bases.ddd.frame.entity.EntityId;

public interface IdentifierGenerable<T extends EntityId> {
    T nextId();
}
