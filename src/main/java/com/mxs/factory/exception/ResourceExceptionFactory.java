package com.mxs.factory.exception;

import com.mxs.factory.type.CategoryExceptionType;
import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;

public final class ResourceExceptionFactory {

    private final CodeExceptionType codeExceptionType;
    private final MessageExceptionType messageExceptionType;
    private final CategoryExceptionType categoryExceptionType;

    private ResourceExceptionFactory(final Builder entityExceptionBuilder) {
        this.codeExceptionType = entityExceptionBuilder.codeExceptionType;
        this.messageExceptionType = entityExceptionBuilder.messageExceptionType;
        this.categoryExceptionType = entityExceptionBuilder.categoryExceptionType;
    }

    public CodeExceptionType getCodeExceptionType() {
        return codeExceptionType;
    }

    public MessageExceptionType getMessageExceptionType() {
        return messageExceptionType;
    }

    public CategoryExceptionType getCategoryExceptionType() { return categoryExceptionType; }

    public static class Builder {

        private CodeExceptionType codeExceptionType;
        private MessageExceptionType messageExceptionType;
        private CategoryExceptionType categoryExceptionType;

        public Builder() { }

        public Builder codeExceptionType(final CodeExceptionType codeExceptionType) {
            this.codeExceptionType = codeExceptionType;
            return this;
        }

        public Builder messageExceptionType(final MessageExceptionType messageExceptionType) {
            this.messageExceptionType = messageExceptionType;
            return this;
        }

        public Builder categoryExceptionType(final CategoryExceptionType categoryExceptionType) {
            this.categoryExceptionType = categoryExceptionType;
            return this;
        }

        public ResourceExceptionFactory build() {
            return new ResourceExceptionFactory(this);
        }
    }
}