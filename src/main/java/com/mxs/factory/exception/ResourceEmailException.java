package com.mxs.factory.exception;

import com.mxs.factory.type.MessageExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public final class ResourceEmailException extends RuntimeException {
    public ResourceEmailException(final MessageExceptionType messageExceptionType) {
        super(messageExceptionType.getCode());
    }
}