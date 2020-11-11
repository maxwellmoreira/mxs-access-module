package com.mxs.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
public final class UserModel extends EntityModel {

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    public UserModel() { }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private UserModel(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
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