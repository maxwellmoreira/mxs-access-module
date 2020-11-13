package com.mxs.domain.user.filter;

public final class LoginFilter {

    private final String username;
    private final String password;

    public LoginFilter(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    private LoginFilter(final Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public final static class Builder {

        private String username;
        private String password;

        public Builder() { }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        public LoginFilter build() {
            return new LoginFilter(this);
        }
    }
}