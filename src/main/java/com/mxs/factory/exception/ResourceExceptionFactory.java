package com.mxs.factory.exception;

public final class ResourceExceptionFactory {

    private final String code;
    private final String message;
    private final String category;

    public String getCode() { return code; }

    public String getMessage() { return message; }

    public String getCategory() { return category; }

    private ResourceExceptionFactory(final Builder entityExceptionBuilder) {
        this.code = entityExceptionBuilder.code;
        this.message = entityExceptionBuilder.message;
        this.category = entityExceptionBuilder.category;
    }

    public static class Builder {

        private String code;
        private String message;
        private String category;

        public Builder() {
        }

        public Builder codeExceptionType(final String code) {
            this.code = code;
            return this;
        }

        public Builder messageExceptionType(final String message) {
            this.message = message;
            return this;
        }

        public Builder categoryExceptionType(final String category) {
            this.category = category;
            return this;
        }

        public ResourceExceptionFactory build() {
            return new ResourceExceptionFactory(this);
        }
    }
}