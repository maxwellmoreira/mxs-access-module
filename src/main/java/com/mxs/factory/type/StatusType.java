package com.mxs.factory.type;

import java.util.stream.Stream;

public enum StatusType {

    ACTIVE("A"),
    INACTIVE("I");

    private final String code;

    StatusType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static StatusType of(final String status) {
        return Stream.of(StatusType.values())
                .filter(s -> s.getCode().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}