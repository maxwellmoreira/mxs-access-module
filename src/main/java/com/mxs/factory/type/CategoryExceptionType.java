package com.mxs.factory.type;

public enum CategoryExceptionType {
    BUSINESS("BUSINESS"),
    INFRASTRUCTURE("INFRASTRUCTURE"),
    ILLEGAL("ILLEGAL");

    private final String code;

    CategoryExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}