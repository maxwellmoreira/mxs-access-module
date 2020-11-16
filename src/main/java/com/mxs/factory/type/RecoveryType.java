package com.mxs.factory.type;

import java.util.stream.Stream;

public enum RecoveryType {

    EMAIL("E");

    private final String code;

    RecoveryType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static RecoveryType of(final String code) {
        if (code == null) { return null; }
        return Stream.of(RecoveryType.values())
                .filter(s -> s.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}