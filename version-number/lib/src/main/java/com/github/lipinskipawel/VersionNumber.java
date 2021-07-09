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
        this.state.compute(givenVersion, (k, v) -> {
            if (v == null) {
                final var list = new ArrayList<T>();
                list.add(value);
                return list;
            } else {
                v.add(value);
                return v;
            }
        });
        return this;
    }

    public Map<Integer, List<T>> value() {
        return new HashMap<>(this.state);
    }
}
