package jp.personal.gi.java.bases.ddd.frame;

import java.util.Optional;
import java.util.function.Predicate;

@FunctionalInterface
public interface Specification<T> {
    boolean isSatisfiedBy(T instance);

    default boolean notSatisfiedBy(T instance) {
        return !isSatisfiedBy(instance);
    }

    default Specification<T> not() {
        return this::notSatisfiedBy;
    }

    default Specification<T> and(Specification<T> otherSpecification) {
        return instance -> this.isSatisfiedBy(instance)
                && otherSpecification.isSatisfiedBy(instance);
    }

    default Specification<T> andNot(Specification<T> otherSpecification) {
        return instance -> this.isSatisfiedBy(instance)
                && otherSpecification.notSatisfiedBy(instance);
    }

    default Specification<T> or(Specification<T> otherSpecification) {
        return instance -> this.isSatisfiedBy(instance)
                || otherSpecification.isSatisfiedBy(instance);
    }

    default Specification<T> orNot(Specification<T> otherSpecification) {
        return instance -> this.isSatisfiedBy(instance)
                || otherSpecification.notSatisfiedBy(instance);
    }

    default Predicate<T> toPredicate() {
        return this::isSatisfiedBy;
    }

    default Optional<T> satisfy(T instance) {
        return this.isSatisfiedBy(instance)
                ? Optional.of(instance)
                : Optional.empty();
    }
}
