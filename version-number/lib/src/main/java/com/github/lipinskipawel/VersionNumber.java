package com.github.lipinskipawel;

import java.util.Objects;
import java.util.Optional;

public final class VersionNumber<T> {
    private final Optional<T> value;
    private final int version;

    VersionNumber() {
        this.value = Optional.empty();
        this.version = 0;
    }

    private VersionNumber(final T value, final int version) {
        this.value = Optional.of(value);
        this.version = version;
    }

    /**
     * This method will insert value to VersionNumber state.
     *
     * @param value        that will be inserted
     * @param givenVersion last seen version of given VersionNumber
     * @return new value with new value and new version
     */
    public VersionNumber<T> insert(final T value, final int givenVersion) {
        if (givenVersion > this.version) {
            return this;
        }
        return new VersionNumber<>(value, this.version + 1);
    }

    public Optional<T> value() {
        return this.value;
    }

    int version() {
        return this.version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionNumber<?> that = (VersionNumber<?>) o;
        return version == that.version && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, version);
    }
}
