package com.github.lipinskipawel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("VersionNumber class")
class VersionNumberTest {

    @Nested
    @DisplayName("version checks")
    class IncreaseVersionNumber {
        @Test
        void shouldStartVersioningFromZero() {
            final var subject = new VersionNumber<String>();
            assertEquals(0, subject.version());
        }

        @Test
        void shouldNotAcceptHigherVersionThanItHas() {
            final var subject = new VersionNumber<Integer>();

            final var afterInsert = subject.insert(1, 34);

            assertEquals(subject, afterInsert);
        }

        @Test
        void shouldIncreaseByOneAfterOneInsert() {
            final var subject = new VersionNumber<Integer>();
            final var afterInsert = subject.insert(400, subject.version());
            assertEquals(0, subject.version(), () -> "Should not mutable object");
            assertEquals(1, afterInsert.version(), () -> "Should increase version by one");
        }

        @Test
        void shouldIncreaseByTwoAfterTwoInserts() {
            final var versionNumber = new VersionNumber<Integer>();

            final var firstInsert = versionNumber.insert(1, 0);
            final var secondInsert = firstInsert.insert(1, 0);

            assertEquals(1, firstInsert.version(), () -> "Should increase version by one");
            assertEquals(2, secondInsert.version(), () -> "Should increase version by one");
        }
    }

    @Nested
    @DisplayName("object checks")
    class ObjectChecks {
        @Test
        void shouldContainEmptyValue() {
            final var subject = new VersionNumber<String>();

            assertEquals(subject.value(), Optional.empty());
        }

        @Test
        void shouldContainOneElement() {
            final var subject = new VersionNumber<String>();

            final var afterInsert = subject.insert("first", 0);

            assertEquals(afterInsert.value(), Optional.of("first"));
        }

        @Test
        void shouldContainSecondElementWhenProvidedNextVersion() {
            final var subject = new VersionNumber<String>();

            final var afterInsert = subject.insert("first", 0);
            final var secondInsert = afterInsert.insert("second", 1);

            assertEquals(secondInsert.value(), Optional.of("second"));
        }
    }
}
