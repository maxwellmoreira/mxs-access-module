package com.mxs.factory.type;

public enum CodeExceptionType {

    EXISTS("0001"),
    NOT_FOUND("0002"),
    ILLEGAL_ARGUMENT("0003");

    private final String code;

    CodeExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}