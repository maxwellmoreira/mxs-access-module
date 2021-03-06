package com.mxs.factory.exception;

import com.mxs.factory.type.MessageExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public final class ResourceExistsException extends RuntimeException {
    public ResourceExistsException(final MessageExceptionType messageExceptionType) {
        super(messageExceptionType.getCode());
    }
}