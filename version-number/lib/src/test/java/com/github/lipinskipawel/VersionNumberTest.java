package com.github.lipinskipawel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("VersionNumber class")
class VersionNumberTest {

    @Nested
    @DisplayName("object checks")
    class ObjectChecks {
        @Test
        void shouldContainEmptyValue() {
            final var subject = new VersionNumber<String>();

            assertEquals(Map.of(), subject.value());
        }

        @Test
        void shouldContainOneElement() {
            final var subject = new VersionNumber<String>();

            final var afterInsert = subject.insert("first", 0);

            assertEquals(Map.of(0, List.of("first")), afterInsert.value());
        }

        @Test
        @Disabled("TODO - override smaller versions when client did merge")
        void shouldContainSecondElementWhenProvidedNextVersion() {
            final var subject = new VersionNumber<String>();

            final var afterInsert = subject.insert("first", 0);
            final var secondInsert = afterInsert.insert("second", 1);

            assertEquals(Map.of(1, List.of("second")), secondInsert.value());
        }
    }

    @Nested
    @DisplayName("concurrent checks")
    class ConcurrentChecks {
        @Test
        void shouldContainTwoElementsAfterSecondConcurrentUpdate() {
            final var subject = new VersionNumber<String>();

            subject.insert("first", 0);
            final var secondInsert = subject.insert("second", 0);

            assertEquals(Map.of(0, List.of("first", "second")), secondInsert.value());
        }
    }
}
