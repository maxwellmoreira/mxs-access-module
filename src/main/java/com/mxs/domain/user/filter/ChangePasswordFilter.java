package com.mxs.domain.user.filter;

public final class ChangePasswordFilter {

    private final String username;
    private final String email;
    private final String password;

    public ChangePasswordFilter(final String username, final String email, final String password) {
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

    public String getPassword() { return password; }

    private ChangePasswordFilter(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public final static class Builder {

        private String username;
        private String email;
        private String password;

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

        public ChangePasswordFilter build() {
            return new ChangePasswordFilter(this);
        }
    }
}