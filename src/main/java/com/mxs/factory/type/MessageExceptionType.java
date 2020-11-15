package com.mxs.factory.type;

import java.util.stream.Stream;

public enum MessageExceptionType {

    USER_EXISTS("User already registered."),
    USERNAME_EXISTS("Username already registered."),
    USER_NOT_FOUND("User not found."),
    ILLEGAL_ARGUMENT("An unexpected error occurred due to an invalid entry.");

    private final String code;

    MessageExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static MessageExceptionType of(final String message) {
        return Stream.of(MessageExceptionType.values())
                .filter(s -> s.getCode().equals(message))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}