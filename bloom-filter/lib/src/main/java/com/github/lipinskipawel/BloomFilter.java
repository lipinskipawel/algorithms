package com.github.lipinskipawel;

import java.util.Objects;

public final class BloomFilter<T> {
    private final int size;
    private int bitMap;

    public BloomFilter() {
        this.bitMap = 0;
        this.size = 1000;
    }

    public void insert(final T object) {
        int hash = object.hashCode();
        int number = hash % this.size;
        this.bitMap |= 1 << number;
    }

    public boolean contain(final T object) {
        int hash = object.hashCode();
        int number = hash % this.size;
        return (this.bitMap & 1 << number) != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloomFilter<?> that = (BloomFilter<?>) o;
        return size == that.size && bitMap == that.bitMap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, bitMap);
    }
}
