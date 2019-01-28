package jp.personal.gi.java.bases.ddd.frame;

import java.util.Optional;
import java.util.function.Predicate;

@FunctionalInterface
public interface Specification<T> extends Predicate<T> {
    @Override
    boolean test(T target);

    @Override
    default Specification<T> and(Predicate<? super T> other) {
        return target -> this.test(target) && other.test(target);
    }

    @Override
    default Specification<T> or(Predicate<? super T> other) {
        return target -> this.test(target) || other.test(target);
    }

    @Override
    default Specification<T> negate() {
        return target -> !test(target);
    }

    default Optional<T> satisfy(T instance) {
        return this.test(instance)
                ? Optional.of(instance)
                : Optional.empty();
    }
}
