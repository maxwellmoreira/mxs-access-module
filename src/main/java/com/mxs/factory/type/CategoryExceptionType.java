package com.mxs.factory.type;

public enum CategoryExceptionType {
    BUSINESS("BUSINESS"),
    INFRASTRUCTURE("INFRASTRUCTURE"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");

    private final String code;

    CategoryExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}