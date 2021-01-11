package com.mxs.dto;

import com.mxs.factory.type.RecoveryType;

public final class RecoverAccessDto {

    private final String username;
    private final String email;
    private final RecoveryType recoveryType;

    public RecoverAccessDto(final String username, final String email, final RecoveryType recoveryType) {
        this.username = username;
        this.email = email;
        this.recoveryType = recoveryType;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RecoveryType getRecoveryType() { return recoveryType; }

    private RecoverAccessDto(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.recoveryType = builder.recoveryType;
    }

    public final static class Builder {

        private String username;
        private String email;
        private RecoveryType recoveryType;

        public Builder() { }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder recoveryType(final RecoveryType recoveryType) {
            this.recoveryType = recoveryType;
            return this;
        }

        public RecoverAccessDto build() {
            return new RecoverAccessDto(this);
        }
    }
}