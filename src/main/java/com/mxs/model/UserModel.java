package com.mxs.model;

public final class UserModel extends EntityModel {

    private final String username;
    private final String email;
    private final String password;

    private UserModel(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
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

    public final static class Builder {

        private String username;
        private String email;
        private String password;

        public Builder() {
        }

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

        public UserModel build() {
            return new UserModel(this);
        }
    }
}