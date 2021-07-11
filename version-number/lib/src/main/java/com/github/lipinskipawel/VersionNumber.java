package com.github.lipinskipawel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class VersionNumber<T> {
    private final Map<Integer, List<T>> state;

    VersionNumber() {
        this.state = new TreeMap<>();
    }

    /**
     * This method will insert value to VersionNumber state.
     *
     * @param value        that will be inserted
     * @param givenVersion last seen version of given VersionNumber
     * @return new value with new value and new version
     */
    public VersionNumber<T> insert(final T value, final int givenVersion) {
        if (this.state.get(givenVersion) == null) {
            this.state.clear();
            this.state.put(givenVersion, List.of(value));
        } else {
            this.state.computeIfPresent(givenVersion, (k, v) -> copyGivenListAndAddElement(v, value));
        }
        return this;
    }

    private List<T> copyGivenListAndAddElement(final List<T> list, final T element) {
        final var copy = new ArrayList<>(list);
        copy.add(element);
        return copy;
    }

    public Map<Integer, List<T>> value() {
        return new HashMap<>(this.state);
    }
}
