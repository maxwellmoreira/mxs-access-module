package com.mxs.domain.user.dto;

public final class SearchDto {

    private final String username;
    private final String email;
    private final String status;

    public SearchDto(final String username,
                     final String email,
                     final String status) {
        this.username = username;
        this.email = email;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() { return status; }

    private SearchDto(final Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.status = builder.status;
    }

    public final static class Builder {

        private String username;
        private String email;
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

        public Builder status(final String status) {
            this.status = status;
            return this;
        }

        public SearchDto build() {
            return new SearchDto(this);
        }
    }
}