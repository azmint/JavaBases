package jp.personal.gi.java.bases.ddd.frame;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class SpecificationTest {
    private static Specification<String> BLANK_TEXT_SPEC = text -> text.trim().isEmpty();
    private static Specification<String> THREE_DIGIT_TEXT_SPEC = text -> text.length() == 3;

    @Test
    public void notSatisfiedBy() {
        assertFalse(BLANK_TEXT_SPEC.notSatisfiedBy(""));
        assertTrue(BLANK_TEXT_SPEC.notSatisfiedBy("A"));
    }

    @Test
    public void not() {
        assertTrue(BLANK_TEXT_SPEC.not().isSatisfiedBy("A"));
        assertFalse(BLANK_TEXT_SPEC.not().isSatisfiedBy(""));
    }

    @Test
    public void and() {
        final Specification<String> result = BLANK_TEXT_SPEC.and(THREE_DIGIT_TEXT_SPEC);
        assertTrue(result.isSatisfiedBy("   "));    // blank And three digit
        assertFalse(result.isSatisfiedBy("  A"));   // not blank And three digit
        assertFalse(result.isSatisfiedBy("AAA"));   // not blank And three digit
        assertFalse(result.isSatisfiedBy(""));      // blank And not three digit
        assertFalse(result.isSatisfiedBy("    "));  // blank And not three digit
        assertFalse(result.isSatisfiedBy("  A "));  // not blank And not three digit
    }

    @Test
    public void andNot() {
        final Specification<String> result = BLANK_TEXT_SPEC.andNot(THREE_DIGIT_TEXT_SPEC);
        assertTrue(result.isSatisfiedBy("    "));  // blank And not three digit
        assertFalse(result.isSatisfiedBy("AA"));     // not blank And not three digit
        assertFalse(result.isSatisfiedBy("AAA"));   // not blank And three digit
        assertFalse(result.isSatisfiedBy("   "));   // blank And three digit
    }

    @Test
    public void or() {
        final Specification<String> result = BLANK_TEXT_SPEC.or(THREE_DIGIT_TEXT_SPEC);
        assertTrue(result.isSatisfiedBy("  A"));    // not blank And three digit
        assertTrue(result.isSatisfiedBy("AAA"));    // not blank And three digit
        assertTrue(result.isSatisfiedBy(""));       // blank And not three digit
        assertTrue(result.isSatisfiedBy("    "));   // blank And not three digit
        assertFalse(result.isSatisfiedBy("  A "));   // not blank And not three digit
    }

    @Test
    public void orNot() {
        final Specification<String> result = BLANK_TEXT_SPEC.orNot(THREE_DIGIT_TEXT_SPEC);
        assertTrue(result.isSatisfiedBy("  "));     // blank And not three digit
        assertFalse(result.isSatisfiedBy("AAA"));   // not blank And three digit
        assertTrue(result.isSatisfiedBy("  A "));  // not blank And not three digit
        assertTrue(result.isSatisfiedBy("   "));   // blank And three digit
    }

    @Test
    public void toPredicate() {
        final Predicate<String> predicate = BLANK_TEXT_SPEC.toPredicate();
        assertTrue(predicate.test(""));
        assertFalse(predicate.test("A"));
    }

    @Test
    public void satisfy() {
        assertThat(BLANK_TEXT_SPEC.satisfy(""), CoreMatchers.is(Optional.of("")));
        assertThat(BLANK_TEXT_SPEC.satisfy("A"), CoreMatchers.is(Optional.empty()));
    }
}