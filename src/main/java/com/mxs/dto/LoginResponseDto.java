package com.mxs.dto;

public final class LoginResponseDto {

    private final String token;

    public LoginResponseDto(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private LoginResponseDto(final Builder builder) {
        this.token = builder.token;
    }

    public final static class Builder {

        private String token;

        public Builder() { }

        public Builder token(final String token) {
            this.token = token;
            return this;
        }

        public LoginResponseDto build() {
            return new LoginResponseDto(this);
        }
    }
}