package com.mxs.factory.type;

public enum CodeExceptionType {

    EXISTS("0001"),
    NOT_FOUND("0002");

    private final String code;

    CodeExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
