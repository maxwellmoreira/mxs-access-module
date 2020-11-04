package com.mxs.factory.type;

public enum MessageExceptionType {

    USER_EXISTS("User already registered."),
    USERNAME_EXISTS("Username already registered."),
    USER_NOT_FOUND("User not found."),
    USER_IS_NULL("User is null.");

    private final String code;

    MessageExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}