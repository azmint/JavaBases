package jp.personal.gi.java.bases.ddd.frame;

import jp.personal.gi.ddd_stockmanagement.domain.support.entity.Entity;

import java.util.function.Predicate;

@FunctionalInterface
public interface Specification<T extends Entity> {
    boolean isSatisfiedBy(T entity);

    default boolean notSatisfiedBy(T entity) {
        return !isSatisfiedBy(entity);
    }

    default Specification<T> not() {
        return this::notSatisfiedBy;
    }

    default Specification<T> and(Specification<T> otherSpecification) {
        return entity -> this.isSatisfiedBy(entity)
                && otherSpecification.isSatisfiedBy(entity);
    }

    default Specification<T> andNot(Specification<T> otherSpecification) {
        return entity -> this.isSatisfiedBy(entity)
                && otherSpecification.notSatisfiedBy(entity);
    }

    default Specification<T> or(Specification<T> otherSpecification) {
        return entity -> this.isSatisfiedBy(entity)
                || otherSpecification.isSatisfiedBy(entity);
    }

    default Specification<T> orNot(Specification<T> otherSpecification) {
        return entity -> this.isSatisfiedBy(entity)
                || otherSpecification.notSatisfiedBy(entity);
    }

    default Predicate<T> toPredicate() {
        return this::isSatisfiedBy;
    }
}
