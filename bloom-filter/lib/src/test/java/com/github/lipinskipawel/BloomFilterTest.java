package com.github.lipinskipawel;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloomFilterTest {

    @Test
    public void shouldNotContainString() {
        final BloomFilter<String> subject = new BloomFilter<>();

        final boolean shouldBeFalse = subject.contain("foo");

        assertFalse(shouldBeFalse);
    }

    @Test
    public void shouldConfirmPresentOfItem() {
        final BloomFilter<String> subject = new BloomFilter<>();
        subject.insert("foo");

        final boolean shouldBeTrue = subject.contain("foo");

        assertTrue(shouldBeTrue);
    }

    @Test
    public void shouldConfirmPresentOfItemWhenThereAreSomeItemsAlready() {
        final BloomFilter<String> subject = new BloomFilter<>();
        subject.insert("bar");
        subject.insert("foo");

        final boolean shouldBeTrue = subject.contain("foo");

        assertTrue(shouldBeTrue);
    }
}
