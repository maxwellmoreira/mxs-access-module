package com.mxs.factory.type;

public enum MessageExceptionType {

    USER_EXISTS("User already registered."),
    USER_NOT_FOUND("User not found.");

    private final String code;

    MessageExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}