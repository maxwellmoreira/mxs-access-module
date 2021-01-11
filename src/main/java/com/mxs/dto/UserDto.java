package com.mxs.dto;

public final class UserDto {

    private final String username;
    private final String email;
    private final String password;
    private final String status;

    public UserDto(final String username,
                   final String email,
                   final String password,
                   final String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() { return status; }

    private UserDto(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.status = builder.status;
    }

    public final static class Builder {

        private String username;
        private String email;
        private String password;
        private String status;

        public Builder() { }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        public Builder status(final String status) {
            this.status = status;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}