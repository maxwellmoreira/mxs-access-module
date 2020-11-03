package com.mxs.factory.type;

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
}
