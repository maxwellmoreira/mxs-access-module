package com.mxs.type;

public enum StatusType {
    ACTIVE("A"),
    INACTIVE("I");

    private String status;

    StatusType(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
