package com.mxs.filter;

public final class UserFilter {
    private final String username;
    private final String email;
    private final String password;

    public UserFilter(final String username,
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