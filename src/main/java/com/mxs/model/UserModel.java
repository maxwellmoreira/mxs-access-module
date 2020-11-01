package com.mxs.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
public final class UserModel extends EntityModel {

    @Column(name = "username")
    private final String username;
    @Column(name = "email")
    private final String email;
    @Column(name = "password")
    private final String password;

    public UserModel(final String username,
                     final String email,
                     final String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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
}